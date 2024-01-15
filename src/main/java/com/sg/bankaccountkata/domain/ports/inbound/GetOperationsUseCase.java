package com.sg.bankaccountkata.domain.ports.inbound;

import com.sg.bankaccountkata.domain.model.TransactionHistory;
import java.util.List;

public interface GetOperationsUseCase {
    List<TransactionHistory> getOperations(String accountNumber);

}
