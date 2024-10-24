package com.microservices.user.service;

import com.microservices.user.entities.Client;
import com.microservices.user.persistance.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> findByNationalId(Long nationalId) {
        return clientRepository.findByNationalId(nationalId);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
