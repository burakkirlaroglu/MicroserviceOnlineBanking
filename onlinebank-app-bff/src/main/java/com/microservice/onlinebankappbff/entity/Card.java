package com.microservice.onlinebankappbff.entity;

import com.microservice.onlinebankappbff.dto.CardDto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    private UUID id;

    private String cardNo;

    private int cardCvc;

    private double amount;

    private String cardType;

    private String cardPassword;

    private double cardLimit;

    private double cardDebt;

    private long customerId;

    public CardDto toCardDto(){
        return CardDto.builder()
                .id(this.id)
                .cardNo(this.cardNo)
                .cardDebt(this.cardDebt)
                .cardType(this.cardType)
                .cardLimit(this.cardLimit)
                .cardPassword(this.cardPassword)
                .customerId(this.customerId)
                .build();
    }
}
