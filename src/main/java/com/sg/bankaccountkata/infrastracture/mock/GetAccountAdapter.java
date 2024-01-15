package com.sg.bankaccountkata.infrastracture.mock;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.AccountType;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import com.sg.bankaccountkata.domain.ports.outbound.SaveAccountPort;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class GetAccountAdapter implements GetAccountPort, SaveAccountPort {

    private Account account = Account.builder()
            .accountNumber("123")
            .balance(0L)
            .history(new ArrayList<>())
            .holderName("holderName")
            .type(AccountType.BUSINESS)
            .build();
    @Override
    public Account getAccount(String accountNumber) {
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        this.account = account;
    }
}
