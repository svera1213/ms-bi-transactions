package com.microservices.transfers.service;

import com.microservices.transfers.entities.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> findAll();
    Transaction findById(Long id);
    void save(Transaction transaction);
    List<Transaction> findAllByOriginAccountId(Long originAccountId);
    List<Transaction> findAllByDestinationAccountId(Long destinationAccountId);
}
