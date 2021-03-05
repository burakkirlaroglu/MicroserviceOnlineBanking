package com.microservice.card.controller;

import com.microservice.card.dto.CardDto;
import com.microservice.card.entity.Card;
import com.microservice.card.service.CardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card addCreditCard(@RequestBody CardDto cardDto){
            return cardService.addCard(cardDto);
    }

    @GetMapping(params = {"page","size"})
    @ResponseStatus(value = HttpStatus.OK)
    public List<CardDto> listCard(@RequestParam("page") int page, @RequestParam("size") int size){
            return cardService.list(PageRequest.of(page,size)).stream()
                    .map(Card::toCardDto)
                    .collect(Collectors.toList());
    }


}
