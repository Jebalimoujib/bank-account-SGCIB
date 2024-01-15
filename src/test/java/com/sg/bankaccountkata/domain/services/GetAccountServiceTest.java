package com.sg.bankaccountkata.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.sg.bankaccountkata.domain.model.Account;
import com.sg.bankaccountkata.domain.ports.outbound.GetAccountPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAccountServiceTest {

    @Mock
    private GetAccountPort mockGetAccountPort;

    private GetAccountService getAccountServiceUnderTest;

    @BeforeEach
    void setUp() {
        getAccountServiceUnderTest = new GetAccountService(mockGetAccountPort);
    }

    @Test
    void testGetAccount() {
        // Setup
        final Account expectedResult = Account.builder().build();
        when(mockGetAccountPort.getAccount("accountNumber")).thenReturn(Account.builder().build());

        // Run the test
        final Account result = getAccountServiceUnderTest.getAccount("accountNumber");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
