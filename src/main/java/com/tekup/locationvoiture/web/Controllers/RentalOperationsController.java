package com.tekup.locationvoiture.web.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.DAO.Entities.Client;
import com.tekup.locationvoiture.DAO.Entities.RentalOperation;
import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.business.services.IClientservice;
import com.tekup.locationvoiture.business.services.IRentOperationService;
import com.tekup.locationvoiture.web.models.Requests.RentForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dashboard/rentcar")
public class RentalOperationsController {
   @Autowired
   IRentOperationService rentCarService;
   @Autowired
   ICarService carService;
   @Autowired
   IClientservice clientService;

//list of rented cars
    @RequestMapping("/rentedcarslist")
    public String rentedCarsList( Model model){
        List<RentalOperation> rentedcars = rentCarService.getAllRentalOperations();
        model.addAttribute("rentedcars", rentedcars);
        return"/Admin/RentedCars";
    }
   //rental car register page 
   @GetMapping("/rentregister")
	public String carRentalRegister(Model model) {
       List<Car> cars = carService.getAllCars();
       model.addAttribute("car", cars);
       List<Client> clients = clientService.getAllClients();
       model.addAttribute("client", clients);
      model.addAttribute("carRentForm", new RentForm());
		return "/Admin/rentCar";
	}
   //add rental operation
   @PostMapping("/save")
   public String AddRentalOperation(@Valid @ModelAttribute("carRentForm") RentForm rentForm,BindingResult bindingResult){
      if(bindingResult.hasErrors()){
         return "/Admin/rentCar";
     }
     RentalOperation rentCar = new RentalOperation( rentForm.getStartDate(), rentForm.getEndDate(), rentForm.getWarrantyType(), rentForm.getPaymentType(), rentForm.getRentalFee(), rentForm.getCar(), rentForm.getClient());
     rentCarService.addRentalOperation(rentCar);
     return "redirect:/dashboard";
   }
   //Update Rental Operation
   @RequestMapping("/editrent/{id}")
   public String updateRentalOperation(@PathVariable("id") Long id ,Model model) {
      Optional<RentalOperation> r=rentCarService.getRentOperation(id);
      model.addAttribute("carRental",r);
      return "/carRentalEdit";
   }
   //delete Rental Operation
   @RequestMapping("/deleterentcar/{id}")
   public String deleteRentalOperation (@PathVariable("id")Long id ) {
      rentCarService.deleteRentalOperation(id);
      return "redirect:/cars";
}
}