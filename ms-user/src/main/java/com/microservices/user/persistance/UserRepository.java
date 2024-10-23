package com.microservices.user.persistance;

import com.microservices.user.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNationalId(Long nationalId);
    Optional<User> findByEmail(String email);
}
