package com.microservice.card.service;

import com.microservice.card.dto.CardDto;
import com.microservice.card.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CardService {

    Page<Card> list(Pageable pageable);

    Card getById(UUID id);

    List<Card> getByCustomerId(Long tc);

    Card shopping(UUID id, CardDto cardDto);

    Card addCard(CardDto cardDto);

}
