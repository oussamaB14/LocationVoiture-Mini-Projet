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

        return "/Admin/Clients";
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
    //update Client page
    @GetMapping("/edit/{id}")
      public String showEditCar(@PathVariable("id")Long id, Model model){
        Optional<Client> client=clientService.getClient(id);
        if(client!=null){
           model.addAttribute("clientForm", new ClientForm(
            client.get().getName(),
            client.get().getCin(),
            client.get().getPhoneNumber(),
            client.get().getAddress(),
            client.get().getAge())); 
            model.addAttribute("idc", id); 
       }
       return "Admin/updateClient";
   }


   //update client
    @PostMapping("/edit/{id}")
	public String editClinet(@PathVariable("id") Long id,@ModelAttribute("clientForm") ClientForm clientForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Admin/updateClient";
        }
        Optional<Client> c =clientService.getClient(id);
        if(c.isPresent()){
            c.get().setName(clientForm.getName());
            c.get().setCin(clientForm.getCin());
            c.get().setPhoneNumber(clientForm.getPhoneNumber());
            c.get().setAddress(clientForm.getAddress());
            c.get().setAge(clientForm.getAge());
            this.clientService.updateClient(c.get());
            return "redirect:/dashboard";
        }
        else {
            return "Admin/updateClient";
        }
		
		
	}
    // delete client
    @RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		clientService.deleteClient(id);
		return "redirect:/dashboard/clients/list";
	}
}