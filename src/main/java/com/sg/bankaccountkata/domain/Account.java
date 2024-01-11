package com.sg.bankaccountkata.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountNumber;
    private String holderName;
    private AccountType type = AccountType.BUSINESS;
    private Long balance;
    private List<TransactionHistory> history;

    public void updateBalance(TransactionType transactionType, Long amount) {
        switch (transactionType) {
            case WITHDRAWAL -> balance = balance - amount;
            case DEPOSIT -> balance = balance + amount;
            default -> throw new NotImplementedException();
        }
    }
}
