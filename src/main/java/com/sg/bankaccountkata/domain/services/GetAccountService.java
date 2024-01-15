package com.sg.bankaccountkata.domain.services;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.ports.inbound.GetAccountUseCase;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAccountService implements GetAccountUseCase {

    private final GetAccountPort getAccountPort;
    @Override
    public Account getAccount(String accountNumber) {
        return getAccountPort.getAccount(accountNumber);
    }
}
