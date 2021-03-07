package com.microservice.onlinebankappbff.dto;

import com.microservice.onlinebankappbff.entity.SavingsAccount;
import com.microservice.onlinebankappbff.utility.enums.currency.Currency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SavingsAccountDto {
    private long accountNumber;
    private String accountIban;
    private int accountBalance;
    private Currency accountCurrency;
    private LocalDate accountCreationDate;
    private int termTime;
    private double grossInterestReturn;
    private double savingsAccountNetGain;
    private double savingsAccountInterestRate;
    private long customerTC;
    public SavingsAccount toSavingsAccount(){
        return SavingsAccount.builder()
                .accountNumber(this.accountNumber)
                .accountIban(this.accountIban)
                .accountBalance(this.accountBalance)
                .accountCurrency(this.accountCurrency)
                .accountCreationDate(this.accountCreationDate)
                .termTime(this.termTime)
                .grossInterestReturn(this.grossInterestReturn)
                .savingsAccountNetGain(this.savingsAccountNetGain)
                .savingsAccountInterestRate(this.savingsAccountInterestRate)
                .customerTC(this.customerTC)
                .build();
    }
}
