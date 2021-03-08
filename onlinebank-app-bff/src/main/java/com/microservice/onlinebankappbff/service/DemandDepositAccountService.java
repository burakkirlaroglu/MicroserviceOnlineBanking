package com.microservice.onlinebankappbff.service;


import com.microservice.onlinebankappbff.entity.DemandDepositAccount;

public interface DemandDepositAccountService extends AccountService<DemandDepositAccount> {
    DemandDepositAccount transferMoney(long demandDepositAccountNumber, long savingsAccountNumber, int money);
}
