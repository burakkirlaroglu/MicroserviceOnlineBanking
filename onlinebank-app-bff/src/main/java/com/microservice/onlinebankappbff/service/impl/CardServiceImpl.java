package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.CardServiceClient;
import com.microservice.onlinebankappbff.entity.Card;
import com.microservice.onlinebankappbff.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardServiceClient cardServiceClient;

    public CardServiceImpl(CardServiceClient cardServiceClient) {
        this.cardServiceClient = cardServiceClient;
    }

    @Override
    public List<Card> getByCustomerId(long tc) {
        return cardServiceClient.get(tc);
    }
}
