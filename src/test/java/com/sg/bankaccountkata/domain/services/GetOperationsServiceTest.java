package com.sg.bankaccountkata.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.model.TransactionHistory;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetOperationsServiceTest {

    @Mock
    private GetAccountPort mockGetAccountPort;

    private GetOperationsService getOperationsServiceUnderTest;

    @BeforeEach
    void setUp() {
        getOperationsServiceUnderTest = new GetOperationsService(mockGetAccountPort);
    }

    @Test
    void testGetOperations() {
        // Setup
        final List<TransactionHistory> expectedResult = List.of(
                TransactionHistory.builder().build());

        // Configure GetAccountPort.getAccount(...).
        final Account account = Account.builder()
                .history(List.of(TransactionHistory.builder().build()))
                .build();
        when(mockGetAccountPort.getAccount("accountNumber")).thenReturn(account);

        // Run the test
        final List<TransactionHistory> result = getOperationsServiceUnderTest.getOperations(
                "accountNumber");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
