package com.microservice.onlinebankappbff.controller;


import com.microservice.onlinebankappbff.dto.CardDto;
import com.microservice.onlinebankappbff.entity.Card;
import com.microservice.onlinebankappbff.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CardController {

    private final CardService<Card> cardService;

    public CardController(CardService<Card> cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card/{id}")
    public CardDto getCardById(@PathVariable UUID id){
        return cardService.getById(id).toCardDto();
    }
}
