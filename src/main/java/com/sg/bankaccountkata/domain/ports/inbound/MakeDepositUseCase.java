package com.sg.bankaccountkata.domain.ports.inbound;

import com.sg.bankaccountkata.domain.model.Transaction;

public interface MakeDepositUseCase {

    void makeDeposit(Transaction transaction);
}
