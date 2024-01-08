package com.tekup.locationvoiture.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.DAO.Entities.Contact;
import com.tekup.locationvoiture.business.services.IContactService;
import com.tekup.locationvoiture.web.models.Requests.CarForm;
import com.tekup.locationvoiture.web.models.Requests.ContactForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/contact")
public class ContactFormController {
    @Autowired
    IContactService contactService;
    @GetMapping()
    public String contactPage(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return"contact";
    }
    @PostMapping("/sendmessage")
    public String sendMessage(@Valid @ModelAttribute("contactForm")  ContactForm contactForm ,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/Admin/AddCar";
        }
        Contact message =new Contact( contactForm.getName(), contactForm.getPhoneNumber(), contactForm.getEmail(), contactForm.getMsg());
        contactService.addContact(message);
        return "redirect:/contact";
        
        
    }
    // @RequestMapping("/delete/{id}")
    //     public String deleteClient(@PathVariable("id")Long id) {
    //         // Optional <Car> car = carService.getCar(id);
    //         // Optional <RentalOperation> rentedCar = carRentService.getRentOperation(id).get().getCar(car);
    //         contactService.
    //                     return "redirect:/dashboard/cars/carslist";
    //     }
}