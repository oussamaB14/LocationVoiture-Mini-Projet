package com.tekup.locationvoiture.web.Controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tekup.locationvoiture.web.Models.Car;

@Controller
@RequestMapping("/cars")
public class CarController {
    private static List<Car> cars = new ArrayList<Car>();
    private static Long idCount = 0L;
    static{
        cars.add(new Car(++idCount, "BMW-10", 200, "BMW", "null", 2013, false, "best car"));
        cars.add(new Car(++idCount, "BMW-12", 700, "BMW", "null", 2017, false, "best car"));
        cars.add(new Car(++idCount, "BMW-90", 500, "BMW", "null", 2012, false, "best car"));
        cars.add(new Car(++idCount, "BMW-70", 800, "BMW", "null", 2023, false, "best car"));
    }
    @GetMapping()
    public ResponseEntity<List<Car>> getAllProducts(){
        // if(this.products.isEmpty())
        // return new ResponseEntity<>("List product is empty",HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(this.cars, HttpStatus.OK);
    }
    // @GetMapping()
    // public String carsList(){
    //     return"carslist";
    // }
}