package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.SavingsAccountServiceClient;
import com.microservice.onlinebankappbff.entity.SavingsAccount;
import com.microservice.onlinebankappbff.service.SavingsAccountService;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountImpl implements SavingsAccountService {
    private final SavingsAccountServiceClient savingsAccountServiceClient;

    public SavingsAccountImpl(SavingsAccountServiceClient savingsAccountServiceClient) {
        this.savingsAccountServiceClient = savingsAccountServiceClient;
    }

    @Override
    public SavingsAccount get(long accountNumber) {
        return savingsAccountServiceClient.get(accountNumber).toSavingsAccount();
    }
}
