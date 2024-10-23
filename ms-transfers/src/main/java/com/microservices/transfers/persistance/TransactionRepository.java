package com.microservices.transfers.persistance;

import com.microservices.transfers.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAllByOriginAccountId(Long originAccountId);
    List<Transaction> findAllByDestinationAccountId(Long destinationAccountId);
}
