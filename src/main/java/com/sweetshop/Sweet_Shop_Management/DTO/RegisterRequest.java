
package com.sweetshop.Sweet_Shop_Management.DTO;

import lombok.Data;

@Data
public class RegisterRequest {
     private String username;
    private String password;
    private String role; // USER or ADMIN

}
