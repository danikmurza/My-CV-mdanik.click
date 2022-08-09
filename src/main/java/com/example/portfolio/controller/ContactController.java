package com.example.portfolio.controller;


import com.example.portfolio.entity.Contact;
import com.example.portfolio.service.ContactService;
import com.example.portfolio.service.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;
    private final Json j;

    @Autowired
    public ContactController(ContactService contactService, Json j) {
        this.contactService = contactService;
        this.j = j;
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> post(Contact dto) {
        this.contactService.save(dto);
        return new ResponseEntity<>(j.m("Thank you i contact soon possimbly"), HttpStatus.ACCEPTED);
    }

}
