package com.microservice.onlinebankappbff.service;

public interface AccountService <T>{
    T get(long accountNumber);
}
