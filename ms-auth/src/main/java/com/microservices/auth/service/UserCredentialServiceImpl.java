package com.microservices.auth.service;

import com.microservices.auth.entities.UserCredential;
import com.microservices.auth.persistance.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCredentialServiceImpl implements IUserCredentialService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    @Override
    public List<UserCredential> findAll() {
        return (List<UserCredential>) userCredentialRepository.findAll();
    }

    @Override
    public Optional<UserCredential> findByEmail(String email) {
        return userCredentialRepository.findByEmail(email);
    }

    @Override
    public void save(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential);
    }
}
