package com.microservice.onlinebankappbff.service.abstrct;

public interface AccountService <T>{
    T get(long accountNumber);
}
