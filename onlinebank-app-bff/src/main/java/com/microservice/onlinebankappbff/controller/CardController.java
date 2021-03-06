package com.microservice.onlinebankappbff.controller;

import com.microservice.onlinebankappbff.entity.Card;
import com.microservice.onlinebankappbff.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card/{tc}")
    public List<Card> getCardByCustomerId(@PathVariable long tc){
        return cardService.getByCustomerId(tc);
    }
}
