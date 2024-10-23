package com.microservices.transfers.controller;

import com.microservices.transfers.entities.Account;
import com.microservices.transfers.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody Account account) {
        accountService.save(account);
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
}
