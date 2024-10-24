package com.microservices.user.service;

import com.microservices.user.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<Client> findAll();
    Client findById(Long id);
    void save(Client client);
    Optional<Client> findByNationalId(Long nationalId);
    Optional<Client> findByEmail(String email);
}
