package com.microservices.transfers.service;

import com.microservices.transfers.entities.Transaction;
import com.microservices.transfers.persistance.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAllByOriginAccountId(Long originAccountId) {
        return (List<Transaction>) transactionRepository.findAllByOriginAccountId(originAccountId);
    }

    @Override
    public List<Transaction> findAllByDestinationAccountId(Long destinationAccountId) {
        return (List<Transaction>) transactionRepository.findAllByDestinationAccountId(destinationAccountId);
    }
}
