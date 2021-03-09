package com.microservice.onlinebankappbff.entity;

import com.microservice.onlinebankappbff.dto.TransferDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    private String fromAccountIBAN;
    private String toAccountIBAN;
    private int money;

    public TransferDto toTransferDto() {
        return TransferDto.builder()
                .fromAccountIBAN(this.fromAccountIBAN)
                .toAccountIBAN(this.toAccountIBAN)
                .money(this.money)
                .build();
    }
}
