package com.sg.bankaccountkata.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountNumber;
    private String holderName;
    private AccountType type = AccountType.BUSINESS;
    private Long balance = 0L;
    private List<TransactionHistory> history;
    private TransactionHystories transactionHystories = new TransactionHystories();

    public void makeDeposit(Long amount) {
        balance = balance + amount;
    }

    public void makeWithdrawal(Long amount) { balance = balance - amount; }
}
