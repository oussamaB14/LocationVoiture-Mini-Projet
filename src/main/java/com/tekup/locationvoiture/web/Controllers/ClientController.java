package com.tekup.locationvoiture.web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.locationvoiture.business.servicesImp.ClientServiceImp;
import com.tekup.locationvoiture.doa.Entities.Client;

@RequestMapping("/clients")
@Controller
public class ClientController {
    @Autowired
    ClientServiceImp clientService;
    @RequestMapping("/list")
    public String listClients(Model model){
         List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);

        return "/clientslist";
    }
}