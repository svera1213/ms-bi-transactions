package com.microservices.transfers.controller;

import com.microservices.transfers.entities.Account;
import com.microservices.transfers.entities.Transaction;
import com.microservices.transfers.service.IAccountService;
import com.microservices.transfers.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ITransactionService transactionService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody Account account) {
        accountService.save(account);
    }

    @PostMapping("/transactions/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendTransaction(@RequestBody Transaction transaction) {
        transactionService.save(transaction);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.findById(id));
    }

    @GetMapping("/NUI/{nationalId}")
    public ResponseEntity<?> findByAllByUserNationalId(@PathVariable Long userNationalId){
        return ResponseEntity.ok(accountService.findAllByUserNationalId(userNationalId));
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> findAllTransactions() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/transactions/origin/{originAccountId}")
    public ResponseEntity<?> findAllByOriginAccountId(Long originAccountId) {
        return ResponseEntity.ok(transactionService.findAllByOriginAccountId(originAccountId));
    }

    @GetMapping("/transactions/destination/{originAccountId}")
    public ResponseEntity<?> findAllByDestinationAccountId(Long destinationAccountId) {
        return ResponseEntity.ok(transactionService.findAllByDestinationAccountId(destinationAccountId));
    }
}
