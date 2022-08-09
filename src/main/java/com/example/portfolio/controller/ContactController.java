package com.example.portfolio.controller;


import com.example.portfolio.entity.Contact;
import com.example.portfolio.service.ContactService;
import com.example.portfolio.service.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public @ResponseBody ResponseEntity<Object> post(@RequestBody Contact dto) throws Exception {
        try {
            if(dto.getEmail() == null){
                return new ResponseEntity<>(j.m("Please fill email"), HttpStatus.BAD_REQUEST);
            }
            this.contactService.save(dto);
            return new ResponseEntity<>(j.m("Thank you i will contact soon possibly"), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(j.m("Somthing wrong"), HttpStatus.BAD_REQUEST);
        }

    }

}
