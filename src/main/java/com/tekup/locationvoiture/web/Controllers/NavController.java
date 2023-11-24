package com.tekup.locationvoiture.web.Controllers;



import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.doa.Entities.Car;



@Controller
@RequestMapping("/")

public class NavController implements ErrorController {
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
     @GetMapping("/contact")
    public String contactPage(){
        return"contact";
    }
     @GetMapping("/about")
    public String aboutPage(){
        return"about";
    }
    
    }

