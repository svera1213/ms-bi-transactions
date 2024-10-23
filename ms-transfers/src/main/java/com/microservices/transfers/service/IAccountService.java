package com.microservices.transfers.service;

import com.microservices.transfers.entities.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();
    Account findById(Long id);
    void save(Account account);
    List<Account> findAllByUserNationalId(Long userNationalId);
}
