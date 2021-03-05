package com.microservice.onlinebankappbff.service.abstrct;

public interface CustomerService<T> {
    T get(long tc);
}
