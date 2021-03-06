package com.microservice.onlinebankappbff.service;

import java.util.UUID;

public interface CardService<T> {

    T getById(UUID uuid);

}
