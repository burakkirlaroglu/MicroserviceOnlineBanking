package com.microservice.onlinebankappbff.dto;

import com.microservice.onlinebankappbff.entity.Address;
import com.microservice.onlinebankappbff.entity.Customer;
import com.microservice.onlinebankappbff.utility.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class CustomerDto {
    private long customerTC;
    private String customerName;
    private String customerLastname;
    private Gender customerGender;
    private String customerPhone;
    private String customerEmail;
    private LocalDate customerBirthDate;
    private boolean isState;
    private Address address;

    public Customer toCustomer() {
        return Customer.builder()
                .customerTC(this.customerTC)
                .customerName(this.customerName)
                .customerLastname(this.customerLastname)
                .customerGender(this.customerGender)
                .customerPhone(this.customerPhone)
                .customerEmail(this.customerEmail)
                .customerBirthDate(this.customerBirthDate)
                .isState(this.isState)
                .address(this.address)
                .build();
    }
}
