
package com.sweetshop.Sweet_Shop_Management.Controller;

import com.sweetshop.Sweet_Shop_Management.DTO.LoginRequest;
import com.sweetshop.Sweet_Shop_Management.DTO.RegisterRequest;
import com.sweetshop.Sweet_Shop_Management.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}