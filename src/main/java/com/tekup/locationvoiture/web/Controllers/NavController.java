package com.tekup.locationvoiture.web.Controllers;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.business.services.ICarService;






@Controller
@RequestMapping("/")

public class NavController implements ErrorController {
    @Autowired
    ICarService carService;
       @GetMapping()
    public String TakeMeHome(){
        return"home";
    }
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
      @GetMapping("/login")
    public String LoginPage(){
        return"login";
    }
 
     @GetMapping("/about")
    public String aboutPage(){
        return"about";
    }
    @GetMapping("/pricing")
    public String PricingPage() {
        return "Pricing";
    }
    //car list page
    @RequestMapping("/carslist")
    public String CarsList( Model model){
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return"carscataloge";
    }
    //single page car show
    @RequestMapping("/carslist/{id}")
    public String SingleCarShow(@PathVariable("id")Long id, Model model){
        Optional<Car> car = carService.getCar(id); 
        model.addAttribute("car", car);
        return"single_car";
    }
    //Cars Category page
       @GetMapping("/category")
    public String CategoryPage(Model model) {
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return "CarCategory";
    }
    // @GetMapping("/dashboard")
    // public String TakeMeTodashboard() {
    //     return "/Admin/dashboard";
    // }
    //  @GetMapping("/dashboard/carslist")
    // public String TakeMeTodashboardCarsList() {
    //     return "/Admin/cars";
    // }
    
    }

