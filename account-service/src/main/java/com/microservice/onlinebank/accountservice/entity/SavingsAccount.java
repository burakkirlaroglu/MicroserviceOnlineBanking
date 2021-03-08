package com.microservice.onlinebank.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservice.onlinebank.accountservice.dto.SavingsAccountDto;
import com.microservice.onlinebank.accountservice.utility.enums.Currency;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class SavingsAccount{
    @Id
    private long accountNumber;
    private String accountIban;
    private int accountBalance;
    private Currency accountCurrency;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accountCreationDate;
    private int termTime;
    private double grossInterestReturn;
    private double savingsAccountNetGain;
    private double savingsAccountInterestRate;
    private long customerTC;

    public SavingsAccountDto toSavingsAccountDto(){
        return SavingsAccountDto.builder()
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
