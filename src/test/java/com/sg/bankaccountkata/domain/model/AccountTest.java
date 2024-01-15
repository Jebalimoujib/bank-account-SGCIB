package com.sg.bankaccountkata.domain.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Mock
    private TransactionHystories mockTransactionHystories;

    private Account accountUnderTest;

    @BeforeEach
    void setUp() {
        accountUnderTest = new Account("accountNumber", "holderName", AccountType.SAVINGS, 100L,
                List.of(TransactionHistory.builder().build()), mockTransactionHystories);
    }

    @Test
    void testMakeDeposit() {
        // Setup
        // Run the test
        accountUnderTest.makeDeposit(10L);

        // Verify the results
        Assertions.assertEquals(110, accountUnderTest.getBalance());
    }

    @Test
    void testMakeWithdrawal() {
        // Setup
        // Run the test
        accountUnderTest.makeWithdrawal(10L);

        // Verify the results
        Assertions.assertEquals(90, accountUnderTest.getBalance());

    }
}
