package com.sg.bankaccountkata.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sg.bankaccountkata.domain.Account;
import com.sg.bankaccountkata.domain.AccountType;
import com.sg.bankaccountkata.domain.TransactionHistory;
import com.sg.bankaccountkata.domain.TransactionType;
import com.sg.bankaccountkata.rest.dto.TransactionDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountServiceImplTest {

    private AccountServiceImpl accountServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        accountServiceImplUnderTest = new AccountServiceImpl();
    }

    @Test
    void testFindAll() {
        // Setup
        final List<Account> expectedResult = List.of( Account.builder()
                .accountNumber("123")
                .balance(0L)
                .history(new ArrayList<>())
                .holderName("holderName")
                .type(AccountType.BUSINESS)
                .build());

        // Run the test
        final List<Account> result = accountServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testFindByAccountNumber() {
        // Setup
        final Account expectedResult =  Account.builder()
                .accountNumber("123")
                .balance(0L)
                .history(new ArrayList<>())
                .holderName("holderName")
                .type(AccountType.BUSINESS)
                .build();

        // Run the test
        final Account result = accountServiceImplUnderTest.findByAccountNumber("accountNumber");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSave() {
        assertThatThrownBy(() -> accountServiceImplUnderTest.save())
                .isInstanceOf(NotImplementedException.class);
    }

    @Test
    void testUpdate() {
        assertThatThrownBy(() -> accountServiceImplUnderTest.update())
                .isInstanceOf(NotImplementedException.class);
    }

    @Test
    void testExecuteTransaction() {
        // Setup
        final TransactionDto transaction = TransactionDto.builder()
                .type(TransactionType.DEPOSIT)
                .amount(0L)
                .build();

        // Run the test
        accountServiceImplUnderTest.executeTransaction("accountNumber", transaction);

        // Verify the results
    }

    @Test
    void testFindAllOperations() {
        // Setup

        // Run the test
        final List<TransactionHistory> result = accountServiceImplUnderTest.findAllOperations(
                "accountNumber");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
