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

    private UUID customerId;

    public static CardDto toCardDto(Card card){
        return CardDto.builder()
                .id(card.id)
                .cardNo(card.cardNo)
                .cardDebt(card.cardDebt)
                .cardType(card.cardType)
                .cardLimit(card.cardLimit)
                .cardPassword(card.cardPassword)
                .customerId(card.customerId)
                .build();
    }

}
