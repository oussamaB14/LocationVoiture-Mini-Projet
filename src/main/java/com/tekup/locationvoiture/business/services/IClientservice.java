package com.tekup.locationvoiture.business.services;

import java.util.Optional;
import java.util.List;
import com.tekup.locationvoiture.doa.Entities.Client;

public interface IClientservice {
    public Optional<Client> getClient(Long id);
    public Client addClient(Client c);
    public Client updateClient(Client c);
    public void deleteClient(Long id);
    public List<Client> getClientByEmail(String email);

}