package com.sg.bankaccountkata.domain.services;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.Transaction;
import com.sg.bankaccountkata.domain.model.TransactionHistory;
import com.sg.bankaccountkata.domain.ports.inbound.MakeDepositUseCase;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import com.sg.bankaccountkata.domain.ports.outbound.SaveAccountPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MakeDepositService implements MakeDepositUseCase {

    private final GetAccountPort getAccountPort;
    private final SaveAccountPort saveAccountPort;
    @Override
    public void makeDeposit(Transaction transaction){
        Account account = getAccountPort.getAccount(transaction.getAccountNumber());
        account.makeDeposit(transaction.getAmount());
        TransactionHistory transactionHistory = TransactionHistory.from(transaction);
        account.getTransactionHystories().addTransactionHistory(transactionHistory);
        saveAccountPort.saveAccount(account);
    }
}
