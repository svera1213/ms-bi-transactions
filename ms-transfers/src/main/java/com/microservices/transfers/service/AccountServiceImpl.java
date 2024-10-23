package com.microservices.transfers.service;

import com.microservices.transfers.entities.Account;
import com.microservices.transfers.persistance.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAllByUserNationalId(Long userNationalId) {
        return (List<Account>) accountRepository.findAllByUserNationalId(userNationalId);
    }
}
