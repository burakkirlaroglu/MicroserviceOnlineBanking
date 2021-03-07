package com.microservice.card.dto;

import com.microservice.card.entity.Card;
import lombok.*;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
public class CardDto {

    @Id
    private UUID id;

    private String cardNo;

    private int cardCvc;

    private double amount;

    private String cardType;

    private String cardPassword;

    private double cardLimit;

    private double cardDebt;

    private long customerId;

    public Card toCard() {
        return Card.builder()
                .id(this.id)
                .cardNo(this.cardNo)
                .cardCvc(this.cardCvc)
                .amount(this.amount)
                .cardDebt(this.cardDebt)
                .cardType(this.cardType)
                .cardLimit(this.cardLimit)
                .cardPassword(this.cardPassword)
                .customerId(this.customerId)
                .build();
    }
}
