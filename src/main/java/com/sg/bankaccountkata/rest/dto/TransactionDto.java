package com.sg.bankaccountkata.rest.dto;


import com.sg.bankaccountkata.domain.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    @NonNull
    private TransactionType type;

    @NonNull
    private Long amount;
}
