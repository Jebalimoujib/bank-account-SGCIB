package com.sg.bankaccountkata.domain.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.Transaction;
import com.sg.bankaccountkata.domain.model.TransactionHystories;
import com.sg.bankaccountkata.domain.model.TransactionType;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import com.sg.bankaccountkata.domain.ports.outbound.SaveAccountPort;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MakeDepositServiceTest {

    @Mock
    private GetAccountPort mockGetAccountPort;
    @Mock
    private SaveAccountPort mockSaveAccountPort;

    private MakeDepositService makeDepositServiceUnderTest;

    @BeforeEach
    void setUp() {
        makeDepositServiceUnderTest = new MakeDepositService(mockGetAccountPort,
                mockSaveAccountPort);
    }

    @Test
    void testMakeDeposit() {
        // Setup
        final Transaction transaction = Transaction.builder()
                .accountNumber("accountNumber")
                .type(TransactionType.DEPOSIT)
                .amount(0L)
                .build();

        // Configure GetAccountPort.getAccount(...).
        final Account account = Account.builder()
                .balance(100L)
                .transactionHystories(TransactionHystories.builder().histories(new ArrayList<>()).build())
                .build();
        when(mockGetAccountPort.getAccount("accountNumber")).thenReturn(account);

        // Run the test
        makeDepositServiceUnderTest.makeDeposit(transaction);

        // Verify the results
        verify(mockSaveAccountPort).saveAccount(Mockito.any());
    }
}
