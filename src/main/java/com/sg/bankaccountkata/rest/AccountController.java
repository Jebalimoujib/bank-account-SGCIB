package com.sg.bankaccountkata.rest;

import com.sg.bankaccountkata.domain.Account;
import com.sg.bankaccountkata.domain.TransactionHistory;
import com.sg.bankaccountkata.rest.dto.TransactionDto;
import com.sg.bankaccountkata.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{accountNumber}")
    Account getByAccountNumber(@PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber);
    }

    @PostMapping("/accounts/{accountNumber}/deposit")
    void deposit(@PathVariable String accountNumber, @RequestBody  TransactionDto transaction) {
        accountService.executeTransaction(accountNumber, transaction);
    }

    @PostMapping("/accounts/{accountNumber}/withdrawal")
    void withdrawal(@PathVariable String accountNumber, @RequestBody TransactionDto transaction) {
        accountService.executeTransaction(accountNumber, transaction);
    }

    @GetMapping("/accounts/{accountNumber}/operations")
    List<TransactionHistory> getAllOperations(@PathVariable String accountNumber) {
        return accountService.findAllOperations(accountNumber);
    }

}
