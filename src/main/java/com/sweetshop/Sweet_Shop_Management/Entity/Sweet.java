
package com.sweetshop.Sweet_Shop_Management.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Sweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private int quantity;
}
