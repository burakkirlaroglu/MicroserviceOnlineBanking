package com.microservice.onlinebank.accountservice.service.abstrct;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService <T>{
    T create(T t);
    T get(long accountNumber);
    String delete(long accountNumber);
    Page<T> getAccounts(Pageable pageable);
}
