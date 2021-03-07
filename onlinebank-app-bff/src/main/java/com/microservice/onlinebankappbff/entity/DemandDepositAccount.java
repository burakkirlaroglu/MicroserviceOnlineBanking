package com.microservice.onlinebankappbff.entity;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import com.microservice.onlinebankappbff.utility.enums.currency.Currency;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandDepositAccount {
    private long accountNumber;
    private String accountIban;
    private int accountBalance;
    private Currency accountCurrency;
    private LocalDate accountCreationDate;
    private long customerTC;
    public DemandDepositAccountDto toDemandDepositAccountDto() {
        return DemandDepositAccountDto.builder()
                .accountNumber(this.accountNumber)
                .accountIban(this.accountIban)
                .accountBalance(this.accountBalance)
                .accountCurrency(this.accountCurrency)
                .accountCreationDate(this.accountCreationDate)
                .customerTC(this.customerTC)
                .build();
    }
}
