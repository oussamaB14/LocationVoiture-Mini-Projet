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
import com.tekup.locationvoiture.DAO.Entities.Client;
import com.tekup.locationvoiture.business.servicesImp.ClientServiceImp;

@RequestMapping("/clients")
@Controller
public class ClientController {
    @Autowired
    ClientServiceImp clientService;
    //list of clients
    @RequestMapping("/list")
    public String listClients(Model model){
         List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);

        return "clientslist";
    }
  // client register page
    @GetMapping("/client_register")
	public String clientRegister() {
		return "/addclient";
	}
     //Add client
    @GetMapping("/save")
    public String AddCar( @ModelAttribute Client c) {
        clientService.addClient(c);
        return "redirect:/Clients";
    }
   //update client
    @RequestMapping("/editCar/{id}")
	public String editClinet(@PathVariable("id") Long id,Model model) {
		Optional<Client> c =clientService.getClient(id);
		model.addAttribute("client",c);
		return "/clientEdit";
	}
    // delete client
    @RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		clientService.deleteClient(id);
		return "redirect:/Clients";
	}
}