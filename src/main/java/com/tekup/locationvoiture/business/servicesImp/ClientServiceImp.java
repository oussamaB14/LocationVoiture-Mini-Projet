package com.tekup.locationvoiture.business.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tekup.locationvoiture.business.services.IClientservice;
import com.tekup.locationvoiture.doa.Entities.Client;
import com.tekup.locationvoiture.doa.Repository.ClientRepository;

public class ClientServiceImp implements IClientservice {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
        //throw new UnsupportedOperationException("Unimplemented method 'getClient'");
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
                 //throw new UnsupportedOperationException("Unimplemented method 'addClient'");
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
        //throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
        //threw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }

    @Override
    public List<Client> getClientByEmail(String email) {
        return clientRepository.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getClientByEmail'");
    }
    
}