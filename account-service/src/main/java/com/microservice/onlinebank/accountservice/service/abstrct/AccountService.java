package com.microservice.onlinebank.accountservice.service.abstrct;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
public interface AccountService <T>{
    T create(T t);
    T get(long accountNumber);
    String delete(long accountNumber);
    Page<T> getAccounts(Pageable pageable);
    List<T> getAccountsByCustomerTC(long tc);
   //T getAccountByCustomerTC(long tc);
}
