package com.example.portfolio.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "data")
    private Date data = new Date();

    @Column(name = "text")
    private String text;
}
