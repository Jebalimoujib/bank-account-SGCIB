package com.sg.bankaccountkata.domain;

import java.time.LocalDateTime;
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
}
