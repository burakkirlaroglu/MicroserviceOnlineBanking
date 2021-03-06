package com.microservice.onlinebankappbff.dto;

import com.microservice.onlinebankappbff.entity.Card;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CardDto {

    private UUID id;

    private String cardNo;

    private int cardCvc;

    private double amount;

    private String cardType;

    private String cardPassword;

    private double cardLimit;

    private double cardDebt;


    public Card toCard(){
        return Card.builder()
                .id(this.id)
                .cardNo(this.cardNo)
                .cardDebt(this.cardDebt)
                .cardType(this.cardType)
                .cardLimit(this.cardLimit)
                .cardPassword(this.cardPassword)
                .build();
    }
}
