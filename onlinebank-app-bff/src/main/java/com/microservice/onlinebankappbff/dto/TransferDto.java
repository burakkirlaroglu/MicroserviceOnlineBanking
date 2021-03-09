package com.microservice.onlinebankappbff.dto;

import com.microservice.onlinebankappbff.entity.Transfer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferDto {
    private String fromAccountIBAN;
    private String toAccountIBAN;
    private int money;

    public Transfer toTransfer(){
        return Transfer.builder()
                .fromAccountIBAN(this.fromAccountIBAN)
                .toAccountIBAN(this.toAccountIBAN)
                .money(this.money)
                .build();
    }
}
