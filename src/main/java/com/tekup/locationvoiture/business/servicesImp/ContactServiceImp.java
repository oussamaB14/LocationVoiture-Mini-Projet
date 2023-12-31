package com.tekup.locationvoiture.business.servicesImp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.locationvoiture.DAO.Entities.Contact;
import com.tekup.locationvoiture.DAO.Repository.ContactRepository;
import com.tekup.locationvoiture.business.services.IContactService;
@Service
public class ContactServiceImp implements IContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Optional<Contact> getContact(Long id) {
        return contactRepository.findById(id);   }

    @Override
    public Contact addContact(Contact c) {
        return contactRepository.save(c);
    }

    @Override
    public List<Contact> getAllContacts() {
       return contactRepository.findAll();
    }

    @Override
    public double getMessagesCount() {
       return contactRepository.count();
    }
    
}