package com.example.portfolio.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @CreatedDate
    @Column(name = "last_visit", nullable = true)
    private Date created;

    @Column(name = "url_avatar", nullable = true)
    private String urlAvatar;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

//    @Enumerated(EnumType.STRING)
//    @Column(name = "roles")
//    private Roles roles;


//    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "_id")
//    private List<Role> roles = new ArrayList<>();

//    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "_id")
//    private List<Address> address = new ArrayList<>();
//
//    @OneToMany(targetEntity = Tickets.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "_id")
//    private List<Tickets> tickets = new ArrayList<>();
//
//    @OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "_id")
//    private List<Orders> orders = new ArrayList<>();
}
