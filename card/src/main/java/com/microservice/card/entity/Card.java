package com.microservice.card.entity;


import com.microservice.card.dto.CardDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
@Builder
@Data
public class Card {

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

    public CardDto toCardDto() {
        return CardDto.builder()
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
