package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.CardServiceClient;
import com.microservice.onlinebankappbff.dto.CardDto;
import com.microservice.onlinebankappbff.service.CardService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardServiceİmpl implements CardService {

    private final CardServiceClient cardServiceClient;

    public CardServiceİmpl(CardServiceClient cardServiceClient) {
        this.cardServiceClient = cardServiceClient;
    }

    @Override
    public Object getById(UUID uuid) {
        return cardServiceClient.get(uuid);
    }
}
