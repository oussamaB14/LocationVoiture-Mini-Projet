package com.tekup.locationvoiture.web.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tekup.locationvoiture.DAO.Entities.RentalOperation;
import com.tekup.locationvoiture.business.services.IRentOperationService;

@Controller
public class RentalOperationsController {
   @Autowired
   IRentOperationService rentCarService;


   //rental car register page 
   @GetMapping("/carrental_register")
	public String carRentalRegister() {
		return "/addrentaloperation";
	}
   //list of rented cars
    @RequestMapping("/dashboard/rentedcarslist")
    public String rentedCarsList( Model model){
        List<RentalOperation> rentedcars = rentCarService.getAllRentalOperations();
        model.addAttribute("rentedcars", rentedcars);
        return"/Admin/Rentedcars";
    }
   //add rental operation
   @GetMapping("/rent_register")
   public String AddRentalOperation(@ModelAttribute RentalOperation r){
     rentCarService.addRentalOperation(r);
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