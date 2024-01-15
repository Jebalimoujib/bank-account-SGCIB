package com.sg.bankaccountkata.domain.model;

import java.time.LocalDateTime;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    private Long id;
    private TransactionType type;
    private Long amount;
    private Long balance;
    private LocalDateTime dateTime;

    public static TransactionHistory from(Transaction transaction) {
        return TransactionHistory.builder()
                .id(new Random().nextLong())
                .amount(transaction.getAmount())
                .dateTime(LocalDateTime.now())
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .build();
    }

}
