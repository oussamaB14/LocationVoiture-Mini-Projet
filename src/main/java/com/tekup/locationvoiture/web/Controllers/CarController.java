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

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.business.services.ICarService;



@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    ICarService carService;
  
    //car list page
    @RequestMapping("/carslist")
    public String CarsList( Model model){
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return"carscataloge";
    }
    // car register page
    @GetMapping("/car_register")
	public String carRegister() {
		return "/addcar";
	}
    //Add car
    @GetMapping("/save")
    public String AddCar( @ModelAttribute Car c) {
        carService.addCar(c);
        return "redirect:/cars";
    }
    //update car
    @RequestMapping("/editCar/{id}")
	public String editCar(@PathVariable("id") Long id,Model model) {
		Optional<Car> c =carService.getCar(id);
		model.addAttribute("car",c);
		return "/carEdit";
	}
    // delete car
    @RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		carService.deleteCar(id);
		return "redirect:/cars";
	}
	
}