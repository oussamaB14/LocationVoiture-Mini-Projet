package com.tekup.locationvoiture.business.services;
import java.util.Optional;
import java.util.List;

import com.tekup.locationvoiture.doa.Entities.Contact;


public interface IContactService {
public Optional<Contact> getContact(Long id);
public Contact addContact(Contact c);
public List<Contact> getAllContacts();
    
}