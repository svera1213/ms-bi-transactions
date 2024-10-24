package com.microservices.transfers.service;

import com.microservices.transfers.dto.DepositRequest;
import com.microservices.transfers.dto.TransactionRequest;
import com.microservices.transfers.entities.Account;
import com.microservices.transfers.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ITransactionService transactionService;

    public void checkTransferAmount(TransactionRequest transactionRequest) {
        Account originAccount = accountService.findById(transactionRequest.getOriginAccountId());
        Double currentBalance = originAccount.getBalance();
        if (currentBalance < transactionRequest.getAmount()) {
            throw new RuntimeException("-----> Not Enough Balance");
        }
    }

    public Account transferAmount(TransactionRequest transactionRequest) {
        Double transferAmount = transactionRequest.getAmount();
        if (transferAmount < 0.0) {
            throw new RuntimeException("-----> Invalid Amount");
        }
        Account destinationAccount = accountService.findById(transactionRequest.getDestinationAccountId());
        Double currentBalance = destinationAccount.getBalance();
        destinationAccount.setBalance(currentBalance + transferAmount);
        accountService.save(destinationAccount);
        Account originAccount = accountService.findById(transactionRequest.getOriginAccountId());
        Double originCurrentBalance = originAccount.getBalance();
        originAccount.setBalance(originCurrentBalance - transferAmount);
        accountService.save(originAccount);
        Transaction transaction = new Transaction(
                originAccount, destinationAccount, transactionRequest, originCurrentBalance, currentBalance
        );
        transactionService.save(transaction);
        return destinationAccount;
    }

    public void deposit(DepositRequest depositRequest) {
        Double amount = depositRequest.getAmount();
        if (amount < 0) {
            throw new RuntimeException("-----> Invalid Deposit Amount");
        }
        Account account = accountService.findById(depositRequest.getAccountId());
        Double balance = account.getBalance();
        account.setBalance(balance + amount);
        Transaction transaction = new Transaction(
                account, depositRequest, balance, balance
        );
        transactionService.save(transaction);
    }
}
