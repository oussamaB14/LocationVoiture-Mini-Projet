package com.tekup.locationvoiture.business.services;

import java.util.Optional;

import com.tekup.locationvoiture.DAO.Entities.Client;

import java.util.List;

public interface IClientservice {
    public Optional<Client> getClient(Long id);
    public Client addClient(Client c);
    public Client updateClient(Client c);
    public void deleteClient(Long id);
    public List<Client> getAllClients();

}