package com.tekup.locationvoiture.web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.business.services.ICarService;
@Controller
@RequestMapping("/dashboard")
public class AdminController {
     @Autowired
    ICarService carService;
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
      @RequestMapping()
    public String CarsListinDasgboard( Model model){
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return"/Admin/dashboard";
    }
}