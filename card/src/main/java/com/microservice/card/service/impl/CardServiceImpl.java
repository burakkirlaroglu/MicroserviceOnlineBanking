package com.microservice.card.service.impl;

import com.microservice.card.Generator.NumberGenerator;
import com.microservice.card.dto.CardDto;
import com.microservice.card.entity.Card;
import com.microservice.card.repository.CardRepository;
import com.microservice.card.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Card getById(int id) {
        return cardRepository.getById(id);
    }

    public Card shopping(int id, CardDto cardDto){
        return null;
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