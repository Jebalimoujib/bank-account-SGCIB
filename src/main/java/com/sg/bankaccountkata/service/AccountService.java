package com.sg.bankaccountkata.service;

import com.sg.bankaccountkata.domain.Account;
import com.sg.bankaccountkata.domain.TransactionHistory;
import com.sg.bankaccountkata.rest.dto.TransactionDto;
import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findByAccountNumber(String accountNumber);

    void save();

    void update();

    void executeTransaction(String accountNumber, TransactionDto transaction);

    List<TransactionHistory> findAllOperations(String accountNumber);
}
