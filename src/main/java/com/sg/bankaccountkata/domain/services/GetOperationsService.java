package com.sg.bankaccountkata.domain.services;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.TransactionHistory;
import com.sg.bankaccountkata.domain.ports.inbound.GetOperationsUseCase;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetOperationsService implements GetOperationsUseCase {

    private final GetAccountPort getAccountPort;
    @Override
    public List<TransactionHistory> getOperations(String accountNumber) {
        Account account = getAccountPort.getAccount(accountNumber);
        return account.getHistory();
    }
}
