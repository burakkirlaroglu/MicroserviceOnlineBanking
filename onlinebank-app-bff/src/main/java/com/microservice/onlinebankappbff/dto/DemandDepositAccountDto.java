package com.microservice.onlinebankappbff.dto;

import com.microservice.onlinebankappbff.entity.DemandDepositAccount;
import com.microservice.onlinebankappbff.utility.enums.currency.Currency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DemandDepositAccountDto {
    private long accountNumber;
    private String accountIban;
    private int accountBalance;
    private Currency accountCurrency;
    private LocalDate accountCreationDate;
    private long customerTC;
    public DemandDepositAccount toDemandDepositAccount(){
        return DemandDepositAccount.builder()
                .accountNumber(this.accountNumber)
                .accountIban(this.accountIban)
                .accountBalance(this.accountBalance)
                .accountCurrency(this.accountCurrency)
                .accountCreationDate(this.accountCreationDate)
                .customerTC(this.customerTC)
                .build();
    }
}
