package com.simran.insurancebackend.controller;

import com.simran.insurancebackend.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody com.simran.insurancebackend.controller.User user) {

        if(user.getUsername().equals("admin") && user.getPassword().equals("123")) {
            return JwtUtil.generateToken(user.getUsername());
        }

        return "Invalid credentials";
    }
}