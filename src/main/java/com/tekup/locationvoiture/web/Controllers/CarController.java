package com.tekup.locationvoiture.web.Controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.util.UUID;
import com.tekup.locationvoiture.DAO.Entities.Car;

import com.tekup.locationvoiture.business.services.ICarService;
import com.tekup.locationvoiture.business.services.IRentOperationService;
import com.tekup.locationvoiture.web.models.Requests.CarForm;

import ch.qos.logback.classic.spi.STEUtil;
import jakarta.validation.Valid;

// import java.nio.file.Path;
// import jakarta.validation.Valid;
// import java.nio.file.Paths;
// import java.nio.file.Files;
// import java.io.IOException;





@Controller
@RequestMapping("/dashboard/cars")
public class CarController {
    @Autowired
    ICarService carService;
    @Autowired
    IRentOperationService carRentService;
    @RequestMapping("/carslist")
    public String CarsListDashboard( Model model){
        List<Car> cars = carService.getAllCars(); 
        model.addAttribute("cars", cars);
        return"Admin/cars";
    }
    
    // car register page
    @GetMapping("/addcar")
	public String carRegister(Model model) {
         model.addAttribute("carForm", new CarForm());
		return "/Admin/AddCar";
	}
    //Add car
    @PostMapping("/save")
    public String AddCar(@Valid @ModelAttribute("carForm") CarForm carForm,@RequestParam("file") MultipartFile file,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/Admin/AddCar";
        }
        // if (!file.isEmpty()) {
        //     try {
        //         // Get the bytes from the uploaded file
        //         byte[] bytes = file.getBytes();
    
        //         // Define the file path where you want to save the uploaded image
        //         String imagePath = "src/main/resources/static/images/" + file.getOriginalFilename();
    
        //         // Save the file to the specified path
        //         Path path = Paths.get(imagePath);
        //         Files.write(path, bytes);
    
        //         // Set the image path in your Car object
        //         carForm.setImg("/images/" + file.getOriginalFilename()); // Adjust the path as needed
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //         // Handle the exception appropriately (e.g., return an error view)
        //         return "error";
        //     }
        // } else {
        //     // Handle the case where no file is selected (optional)
        //     // You may want to set a default image or display an error message
        //     carForm.setImg("/images/default.jpg"); // Adjust the default image path as needed
        // }
    
        // StringBuilder fileNames = new StringBuilder();
        // Path fileNameAndPath = Paths.get("src/main/resources/static/images",file.getOriginalFilename());
        // fileNames.append(file.getOriginalFilename());
        // try {
        //     Files.write(fileNameAndPath, file.getBytes());
        // } catch (IOException e) {
        //     // Handle the exception here, for example by logging it
        //     e.printStackTrace();
        // }
        try {
            if (file != null && !file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imagePath = "src/main/resources/static/images/" + file.getOriginalFilename();
                Path path = Paths.get(imagePath);
                Files.write(path, bytes);
    
                // Set the image path directly in the Car entity
                carForm.setImg("/images/" + file.getOriginalFilename()); // Adjust the path as needed
    
                // Other Car creation logic...
                // Here, you might want to use carForm.getImg() for setting the image path in the Car entity.
            } else {
                // Handle the case where no file is selected (optional)
                // You may want to set a default image or display an error message
                carForm.setImg("/images/default.jpg"); // Adjust the default image path as needed
            }
        Car car=new Car(
            carForm.getName(),
            carForm.getPrice(),
            carForm.getBrand(),
            carForm.getImg(),
            carForm.getMillage(),
            carForm.getFuelType(), 
            carForm.getTransmissionType(),
            carForm.getYear(),
            true,
            carForm.getDescription());
            carService.addCar(car);
        return "redirect:/dashboard"; } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
    //update car page
    @GetMapping("/edit/{id}")
    public String showEditCar(@PathVariable("id")Long id, Model model){
        Optional<Car> car=carService.getCar(id);
        if(car!=null){
           model.addAttribute("carForm", new CarForm(
            car.get().getName(),
            id, car.get().getBrand(),
            car.get().getImg(),
            car.get().getMillage(),
            car.get().getFuelType(), 
            car.get().getTransmissionType(),
            car.get().getYear(),
            true,
            car.get().getDescription()));
           model.addAttribute("idc", id); 
       }
       return "Admin/updateCar";
   }
    //update car
      @PostMapping("/edit/{id}")
    public String updateCarById(@PathVariable("id") Long id, @ModelAttribute("carForm") CarForm carForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Admin/updateCar";
        }
        Optional<Car> car = carService.getCar(id);
        if (car.isPresent()) {
            car.get().setName(carForm.getName());
            car.get().setBrand(carForm.getBrand());
            car.get().setImg(carForm.getImg());
            car.get().setFuelType(carForm.getFuelType());
            car.get().setTransmissionType(carForm.getTransmissionType());
            car.get().setMillage(carForm.getMillage());
            car.get().setAvailable(true);
            car.get().setYear(carForm.getYear());
            car.get().setPrice(carForm.getPrice());
            car.get().setDescription(carForm.getDescription());
            this.carService.updateCar(car.get());
            return "redirect:/dashboard";
        } else {
            return "Admin/updateCar";
        }
    }
    // delete car
    @RequestMapping("/delete/{id}")
	public String deleteCar(@PathVariable("id")Long id) {
        // Optional <Car> car = carService.getCar(id);
        // Optional <RentalOperation> rentedCar = carRentService.getRentOperation(id).get().getCar(car);
		carService.deleteCar(id);
		return "redirect:/dashboard/carslist";
	}
	

}