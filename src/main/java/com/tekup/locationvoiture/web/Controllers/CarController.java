package com.tekup.locationvoiture.web.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.doa.Entities.Car;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    ICarService carService;
    @RequestMapping("/carslist")
    public ResponseEntity<Object> getCars(){
        return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
    }
    @RequestMapping("/{id}")
    public ResponseEntity<Object> getCarsById(@PathVariable("id") Long id)
    {
        Optional<Car> car=carService.getCar(id);
        if(car.isPresent()){
            return new ResponseEntity<>(car.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("failed: car not found",HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public String carsPage( Model model){
         List<Car> cars = carService.getAllCars(); // Replace with your actual service method
        model.addAttribute("cars", cars);
        return"redirect :carslist";
    }
}