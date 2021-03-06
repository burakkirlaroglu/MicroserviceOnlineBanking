package com.microservice.card.service.impl;

import com.microservice.card.Generator.NumberGenerator;
import com.microservice.card.dto.CardDto;
import com.microservice.card.entity.Card;
import com.microservice.card.repository.CardRepository;
import com.microservice.card.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class CardServiceImpl extends NumberGenerator implements CardService {

    private final CardRepository cardRepository;

    protected CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Page<Card> list(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    public Card getById(UUID id) {
        return cardRepository.getById(id);
    }

    public Card shopping(UUID id, CardDto cardDto){
        Card card = cardRepository.getById(id);
        if (card.getCustomerId() != null){
            double amount = cardDto.getAmount();
            double cardDebt = card.getCardDebt();
            if (card.getCardNo().equals(cardDto.getCardNo()) &
                    card.getCardPassword().equals(cardDto.getCardPassword()) &
                    card.getCardCvc() == cardDto.getCardCvc()) {
                card.setCardLimit(card.getCardLimit() - amount);
                card.setCardDebt(cardDebt + amount);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Cvc or Card No or Password!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no customer with id "+card.getCustomerId());
        }
        return card;
    }

    public Card addCard(CardDto cardDto) {
        Card card = new Card();
        card.setId(UUID.randomUUID());
        card.setCardNo(createCardNo());
        card.setCardDebt(cardDto.getCardDebt());
        card.setCardType(cardDto.getCardType());
        card.setCardLimit(cardDto.getCardLimit());
        card.setCardPassword(cardDto.getCardPassword());
        card.setAmount(cardDto.getAmount());
        card.setCardCvc(ccvNo());
        card.setCustomerId(cardDto.getCustomerId());
        cardRepository.save(card);
        return card;
    }
}