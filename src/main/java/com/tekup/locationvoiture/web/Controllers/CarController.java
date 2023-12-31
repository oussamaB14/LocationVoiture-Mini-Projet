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
import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.web.models.Requests.CarForm;

import jakarta.validation.Valid;



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
    @GetMapping("/addcar")
	public String carRegister(Model model) {
         model.addAttribute("carForm", new CarForm());
		return "/Admin/AddCar";
	}
    //Add car
    @PostMapping("/save")
    public String AddCar(@Valid @ModelAttribute("carForm") CarForm carForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/Admin/AddCar";
        }
        Car car=new Car(carForm.getName(), carForm.getPrice(), carForm.getBrand(), carForm.getImg(), carForm.getMillage(), carForm.getFuelType(), carForm.getTransmissionType(), carForm.getYear(),true, carForm.getDescription());
        carService.addCar(car);
        return "redirect:/dashboard";
    }
    //  @PostMapping("/create")
    // public String addProuct(@Valid @ModelAttribute("productForm") CarForm cartForm, BindingResult bindingResult) {
    //     if(bindingResult.hasErrors()){
    //         return "create";
    //     }
    //     cars.add(new Car(++idCount,  null));
        
    //     return "redirect:/products";
    // }
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