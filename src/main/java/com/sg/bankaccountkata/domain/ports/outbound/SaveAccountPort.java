package com.sg.bankaccountkata.domain.ports.outbound;

import com.sg.bankaccountkata.domain.model.Account;

public interface SaveAccountPort {

    void saveAccount(Account account);
}
