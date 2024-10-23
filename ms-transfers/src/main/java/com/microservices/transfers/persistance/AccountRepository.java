package com.microservices.transfers.persistance;

import com.microservices.transfers.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findAllByUserNationalId(Long userNationalId);
}
