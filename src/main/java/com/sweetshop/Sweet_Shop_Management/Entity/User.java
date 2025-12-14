
package com.sweetshop.Sweet_Shop_Management.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    
    private String email;
     private String phone;

    private String role; // USER or ADMIN

}