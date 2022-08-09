package com.example.portfolio.service;

import com.example.portfolio.entity.Contact;
import com.example.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public void save(Contact data) {
        System.out.println(data.getName());
        this.contactRepository.save(data);
    }


}
