package com.tekup.locationvoiture.business.services;
import java.util.Optional;

import com.tekup.locationvoiture.DAO.Entities.Contact;

import java.util.List;


public interface IContactService {
public Optional<Contact> getContact(Long id);
public Contact addContact(Contact c);
public List<Contact> getAllContacts();
public double getMessagesCount();
    
}