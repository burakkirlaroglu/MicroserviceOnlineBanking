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

import java.util.List;
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

    @Override
    public List<Card> getByCustomerId(Long tc) {
        return cardRepository.getByCustomerId(tc);
    }

    public Card shopping(UUID id, Card card) {
        Card editedCard = cardRepository.getById(id);
        if (editedCard.getCustomerId() > 0) {
            double amount = card.getAmount();
            double cardDebt = editedCard.getCardDebt();
            if (editedCard.getCardNo().equals(card.getCardNo()) &
                    editedCard.getCardPassword().equals(card.getCardPassword()) &
                    editedCard.getCardCvc() == card.getCardCvc()) {
                editedCard.setCardLimit(editedCard.getCardLimit() - amount);
                editedCard.setCardDebt(cardDebt + amount);
                cardRepository.save(editedCard);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Cvc or Card No or Password!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no customer with id " + editedCard.getCustomerId());
        }
        return editedCard;
    }

    public Card addCard(Card card) {
        card.setId(UUID.randomUUID());
        card.setCardNo(createCardNo());
        card.setCardCvc(ccvNo());
        return cardRepository.save(card);
    }
}