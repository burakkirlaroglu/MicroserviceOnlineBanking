package com.microservice.onlinebankappbff.service;

import com.microservice.onlinebankappbff.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> getByCustomerId(long tc);

}
