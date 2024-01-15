package com.sg.bankaccountkata.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHystories {

    private List<TransactionHistory> histories = new ArrayList<>();
    public void addTransactionHistory(TransactionHistory transactionHistory) {
        histories.add(transactionHistory);
    }
}
