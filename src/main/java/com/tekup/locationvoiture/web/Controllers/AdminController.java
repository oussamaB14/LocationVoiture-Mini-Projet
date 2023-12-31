package com.tekup.locationvoiture.web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.business.services.IClientservice;
import com.tekup.locationvoiture.business.services.IRentOperationService;
@Controller
@RequestMapping("/dashboard")
public class AdminController {
     @Autowired
    ICarService carService;
    @Autowired
    IClientservice clientService;
    @Autowired
    IRentOperationService rentService;
    // @GetMapping()
    // public String TakeMeTodashboard() {
    //     return "/Admin/dashboard";
    // }
    @RequestMapping("/carslist")
    public String CarsList( Model model){
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return"Admin/cars";
    }
    // car register page
    // @GetMapping("/addcar")
	// public String carRegister() {
	// 	return "/Admin/AddCar";
	// }
      @RequestMapping()
    public String CarsListingDasgboard( Model model){
        List<Car> cars = carService.getAllCars(); 
        double carCount =carService.getNumberOfCars();
        double clientCount =clientService.getNumberOfClients();
        double rentedCarsCount =rentService.getRentedCarsCount();
        model.addAttribute("rentedCarsCount", rentedCarsCount);
        model.addAttribute("carCount", carCount);
        model.addAttribute("clientCount", clientCount);
        model.addAttribute("cars", cars);
        return"/Admin/dashboard";
    }
}