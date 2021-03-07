package com.microservice.onlinebankappbff.entity;

import com.microservice.onlinebankappbff.dto.CustomerDto;
import com.microservice.onlinebankappbff.utility.enums.gender.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private long customerTC;
    private String customerName;
    private String customerLastname;
    private Gender customerGender;
    private String customerPhone;
    private String customerEmail;
    private LocalDate customerBirthDate;
    private boolean isState;
    private Address address;
    private List<Card> cards;
    private List<DemandDepositAccount> demandDepositAccounts;
    private List<SavingsAccount> savingsAccounts;

    public CustomerDto toCustomerDto() {
        return CustomerDto.builder()
                .customerTC(this.customerTC)
                .customerName(this.customerName)
                .customerLastname(this.customerLastname)
                .customerGender(this.customerGender)
                .customerPhone(this.customerPhone)
                .customerEmail(this.customerEmail)
                .customerBirthDate(this.customerBirthDate)
                .address(this.address)
                .cards(this.cards)
                .demandDepositAccounts(this.demandDepositAccounts)
                .savingsAccounts(this.savingsAccounts)
                .build();
    }
}
