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
import com.tekup.locationvoiture.web.models.Requests.CarForm;
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
     // Get the associated car
    Car rentedCar = rentForm.getCar();
    // Update the availability status of the car to false
    if (rentedCar != null) {
        rentedCar.setAvailable(false);
        carService.updateCar(rentedCar); // Assuming you have a method to update the car in your service
    }
     return "redirect:/dashboard";
   }
   //Update Rental Operation page
   @GetMapping("/edit/{id}")
   public String updateRentalOperation(@PathVariable("id") Long id ,Model model) {
      Optional<RentalOperation> rentedCar=rentCarService.getRentOperation(id);
      if(rentedCar!=null){
          model.addAttribute("rentForm",new RentForm(
            rentedCar.get().getStartDate(),
            rentedCar.get().getEndDate(), 
            rentedCar.get().getWarrantyType(),
            rentedCar.get().getPaymentType(),
            rentedCar.get().getRentalFee(),
            rentedCar.get().getCar(),
            rentedCar.get().getClient()
          ));
          model.addAttribute("idr", id); 
      }
     
      return "/Admin/updateRentalOperation";
   }
   //update rental operation 
   @PostMapping("/edit/{id}")
    public String updateCarById(@PathVariable("id") Long id, @ModelAttribute("rentForm") RentForm rentForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Admin/updateRentalOperation";
        }
        Optional<RentalOperation> rent = rentCarService.getRentOperation(id);
                if (rent.isPresent()) {
            rent.get().setStartDate(rentForm.getStartDate());
            rent.get().setEndDate(rentForm.getEndDate());
            rent.get().setWarrantyType(rentForm.getWarrantyType());
            rent.get().setPaymentType(rentForm.getPaymentType());
            rent.get().setRentalFee(rentForm.getRentalFee());
            rent.get().setCar(rentForm.getCar());
            rent.get().setClient(rentForm.getClient());
            this.rentCarService.updateRentalOperation(rent.get());
            return "redirect:/dashboard";
        } else {
            return "Admin/updateRentalOperation";
        }
    }
   //delete Rental Operation
   @RequestMapping("/delete/{id}")
   public String deleteRentalOperation (@PathVariable("id")Long id ) {
      Optional<RentalOperation> rentalOperation = rentCarService.getRentOperation(id);
      rentCarService.deleteRentalOperation(id);
      if (rentalOperation != null && rentalOperation.get() != null) {
         Car rentedCar = rentalOperation.get().getCar();
         // Set isAvailable to true
         rentedCar.setAvailable(true);
         // Update the car in the database
         carService.updateCar(rentedCar); }
      return "redirect:/dashboard/rentcar/rentedcarslist";}
      }
