package com.sg.bankaccountkata.domain.ports.inbound;

import com.sg.bankaccountkata.domain.model.Account;

public interface GetAccountUseCase {
    Account getAccount(String accountNumber);

}
