package com.microservice.card.dto;

import com.microservice.card.entity.Card;
import lombok.*;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private UUID customerId;
}
