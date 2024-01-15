package com.sg.bankaccountkata.application.rest.controller;

import com.sg.bankaccountkata.application.rest.request.TransactionRequest;
import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.Transaction;
import com.sg.bankaccountkata.domain.model.TransactionHistory;
import com.sg.bankaccountkata.domain.model.TransactionType;
import com.sg.bankaccountkata.domain.ports.inbound.GetAccountUseCase;
import com.sg.bankaccountkata.domain.ports.inbound.GetOperationsUseCase;
import com.sg.bankaccountkata.domain.ports.inbound.MakeDepositUseCase;
import com.sg.bankaccountkata.domain.ports.inbound.MakeWithdrawalUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountController {

    private final GetAccountUseCase getAccountUseCase;
    private final GetOperationsUseCase getOperationsUseCase;
    private final MakeDepositUseCase makeDepositUseCase;
    private final MakeWithdrawalUseCase makeWithdrawalUseCase;

    @GetMapping("/accounts/{accountNumber}")
    Account getByAccountNumber(@PathVariable String accountNumber) {
        return getAccountUseCase.getAccount(accountNumber);
    }

    @PostMapping("/accounts/{accountNumber}/deposit")
    void deposit(@PathVariable String accountNumber, @RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .accountNumber(accountNumber)
                .type(TransactionType.WITHDRAWAL)
                .amount(transactionRequest.getAmount())
                .build();
        makeDepositUseCase.makeDeposit(transaction);
    }

    @PostMapping("/accounts/{accountNumber}/withdrawal")
    void withdrawal(@PathVariable String accountNumber, @RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .accountNumber(accountNumber)
                .type(TransactionType.WITHDRAWAL)
                .amount(transactionRequest.getAmount())
                .build();
        makeWithdrawalUseCase.makeWithdrawal(transaction);
    }

    @GetMapping("/accounts/{accountNumber}/operations")
    List<TransactionHistory> getAllOperations(@PathVariable String accountNumber) {
        return getOperationsUseCase.getOperations(accountNumber);
    }

}
