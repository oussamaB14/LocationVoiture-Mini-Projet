package com.tekup.locationvoiture.web.Controllers;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tekup.locationvoiture.DAO.Entities.Car;
import com.tekup.locationvoiture.DAO.Entities.CarSpecification;
import com.tekup.locationvoiture.DAO.Entities.TransmissionType;
import com.tekup.locationvoiture.DAO.Repository.CarRepository;
import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.web.models.Requests.CarForm;
import org.springframework.web.bind.annotation.ModelAttribute;





@Controller
@RequestMapping("/")

public class NavController implements ErrorController {
    @Autowired
    ICarService carService;
    @Autowired
    CarRepository carRepository;
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
    @RequestMapping(value ="/carslist/{id}" , method = RequestMethod.GET)
    public String SingleCarShow(@PathVariable("id")Long id, Model model){
        Optional<Car> optionalCar = carService.getCar(id); 
        if(optionalCar.isPresent()){
            Car car=optionalCar.get();
            model.addAttribute("car", car);
            return"single_car";
        }
        
        return"single_car";
    }
    //Cars Category page
    @GetMapping("/category")
    public String CategoryPage(Model model) {
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return "CarCategory";
    }
    // filter logic category page
    @RequestMapping("/search")
     public String FilterCars(
            @ModelAttribute("carForm") CarForm carForm,
            @RequestParam(value = "brand" , required = false) String brand,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "transmissionType", required = false) TransmissionType transmissionType,
            @RequestParam(value = "status", required = false) boolean status,
             Model model) {
    List<Car> cars = carService.getCarsByName(name);
              cars = carService.getCarsByBrandName(brand);
              cars = carService.getCarsByAvailability(status);
              cars = carService.getCarsByTranmissionType(transmissionType);
    // Specification<Car> spec = new CarSpecification (brand, name, transmissionType, status);
    // List<Car> cars = carRepository.findAll(spec);
    if (cars == null || cars.isEmpty()) {
        model.addAttribute("message", "No results found");}

    model.addAttribute("cars", cars);
    return "/CarCategory";
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

