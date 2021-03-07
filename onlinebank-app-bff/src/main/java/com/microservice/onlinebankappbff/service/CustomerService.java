package com.microservice.onlinebankappbff.service;

public interface CustomerService<T> {
    T get(long tc);
}
