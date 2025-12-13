
package com.sweetshop.Sweet_Shop_Management.Service;

import com.sweetshop.Sweet_Shop_Management.Config.JwtUtil;
import com.sweetshop.Sweet_Shop_Management.DTO.LoginRequest;
import com.sweetshop.Sweet_Shop_Management.DTO.RegisterRequest;
import com.sweetshop.Sweet_Shop_Management.Entity.User;
import com.sweetshop.Sweet_Shop_Management.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepo.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}