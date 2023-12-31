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
import com.tekup.locationvoiture.DAO.Entities.Client;
import com.tekup.locationvoiture.business.servicesImp.ClientServiceImp;
import com.tekup.locationvoiture.web.models.Requests.CarForm;
import com.tekup.locationvoiture.web.models.Requests.ClientForm;

import jakarta.validation.Valid;

@RequestMapping("/dashboard/clients")
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
    @GetMapping("/addclient")
	public String clientRegister(Model model) {
        model.addAttribute("clientForm", new ClientForm());
		return "Admin/AddClients";
	}
     //Add client
    @PostMapping("/save")
    public String AddClient( @Valid @ModelAttribute("clientForm") ClientForm clientForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/Admin/AddClients";
        }
        Client client=new Client(clientForm.getName(),clientForm.getCin(), clientForm.getPhoneNumber(), clientForm.getAddress(), clientForm.getAge());
        clientService.addClient(client);
        return "redirect:/dashboard";
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