package com.microservices.auth.controller;

import com.microservices.auth.client.UserClient;
import com.microservices.auth.dto.AuthRequest;
import com.microservices.auth.dto.ClientRequest;
import com.microservices.auth.dto.RegisterRequest;
import com.microservices.auth.entities.UserCredential;
import com.microservices.auth.service.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserCredentialService userCredentialService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserClient userClient;

    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterRequest registerRequest) {
        UserCredential userCredential = new UserCredential(registerRequest);
        userCredentialService.save(userCredential);
        ClientRequest clientRequest = new ClientRequest(registerRequest);
        userClient.saveUser(clientRequest);
        return userCredentialService.generateToken(registerRequest.getEmail());
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userCredentialService.generateToken(authRequest.getEmail());
        } else {
            throw new RuntimeException("Invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userCredentialService.validateToken(token);
        return "Token is valid";
    }
}
