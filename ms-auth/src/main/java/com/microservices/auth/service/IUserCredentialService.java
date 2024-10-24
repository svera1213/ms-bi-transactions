package com.microservices.auth.service;

import com.microservices.auth.entities.UserCredential;

import java.util.List;
import java.util.Optional;

public interface IUserCredentialService {

    List<UserCredential> findAll();
    Optional<UserCredential> findByEmail(String email);
    void save(UserCredential userCredential);
    String generateToken(String email);
    void validateToken(String token);
}
