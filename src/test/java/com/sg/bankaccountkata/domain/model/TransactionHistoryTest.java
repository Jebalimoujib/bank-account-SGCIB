package com.sg.bankaccountkata.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionHistoryTest {

    @Test
    void testFrom() {
        // Setup
        final Transaction transaction = Transaction.builder()
                .type(TransactionType.DEPOSIT)
                .accountNumber("accountNumber")
                .amount(10L)
                .build();

        // Run the test
        final TransactionHistory result = TransactionHistory.from(transaction);
        assertThat(result.getType()).isEqualTo(TransactionType.DEPOSIT);
        assertThat(result.getAmount()).isEqualTo(10L);
        Assertions.assertNotNull(result.getDateTime());
        Assertions.assertNotNull(result.getId());
    }
}
