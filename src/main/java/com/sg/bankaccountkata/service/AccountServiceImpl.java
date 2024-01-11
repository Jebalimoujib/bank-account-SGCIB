package com.sg.bankaccountkata.service;

import com.sg.bankaccountkata.domain.Account;
import com.sg.bankaccountkata.domain.AccountType;
import com.sg.bankaccountkata.rest.dto.TransactionDto;
import com.sg.bankaccountkata.domain.TransactionHistory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    Random random = new Random();
    private final Account account = Account.builder()
            .accountNumber("123")
            .balance(0L)
            .history(new ArrayList<>())
            .holderName("holderName")
            .type(AccountType.BUSINESS)
            .build();

    @Override
    public List<Account> findAll() {
        return List.of(account);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return account;
    }

    @Override
    public void save() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void update() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void executeTransaction(String accountNumber, TransactionDto transaction){
        account.updateBalance(transaction.getType(), transaction.getAmount());
        TransactionHistory transactionHistory = TransactionHistory.builder()
                .id(random.nextLong())
                .amount(transaction.getAmount())
                .dateTime(LocalDateTime.now())
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .balance(account.getBalance())
                .build();
        account.getHistory().add(transactionHistory);
    }

    @Override
    public List<TransactionHistory> findAllOperations(String accountNumber) {
        return account.getHistory();
    }

}
