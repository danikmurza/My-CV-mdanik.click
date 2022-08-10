package com.example.portfolio.controller;


import com.example.portfolio.configuration.MailConfiguration;
import com.example.portfolio.entity.Contact;
import com.example.portfolio.service.ContactService;
import com.example.portfolio.service.EmailService;
import com.example.portfolio.service.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {


    @Value("${gmail}")
    private String gmail;

    private final ContactService contactService;
    private final Json j;

    private final EmailService emailService;

    @Autowired
    public ContactController(ContactService contactService, Json j,  EmailService emailService) {
        this.contactService = contactService;
        this.j = j;
        this.emailService = emailService;

    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Object> post(@RequestBody Contact dto) throws Exception {
        try {
            if(dto.getEmail() == null){
                return new ResponseEntity<>(j.m("Please fill email"), HttpStatus.BAD_REQUEST);
            }
            this.contactService.save(dto);
            this.emailService
                    .sendSimpleMessage(this.gmail, dto.getSubject(), dto.getEmail() + " = "+dto.getText());

            return new ResponseEntity<>(j.m("Thank you i will contact soon possibly"), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(j.m("Somthing wrong"), HttpStatus.BAD_REQUEST);
        }

    }

}
