package com.microservices.user.persistance;

import com.microservices.user.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByNationalId(Long nationalId);
    Optional<Client> findByEmail(String email);
}
