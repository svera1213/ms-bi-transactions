package com.microservices.user.service;

import com.microservices.user.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    void save(User user);
    Optional<User> findByNationalId(Long nationalId);
    Optional<User> findByEmail(String email);
}
