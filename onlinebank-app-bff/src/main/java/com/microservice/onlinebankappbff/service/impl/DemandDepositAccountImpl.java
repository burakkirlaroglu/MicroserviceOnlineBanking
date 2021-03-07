package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.DemandDepositAccountServiceClient;
import com.microservice.onlinebankappbff.entity.DemandDepositAccount;
import com.microservice.onlinebankappbff.service.DemandDepositAccountService;
import org.springframework.stereotype.Service;

@Service
public class DemandDepositAccountImpl implements DemandDepositAccountService {
    private final DemandDepositAccountServiceClient demandDepositAccountServiceClient;

    public DemandDepositAccountImpl(DemandDepositAccountServiceClient demandDepositAccountServiceClient) {
        this.demandDepositAccountServiceClient = demandDepositAccountServiceClient;
    }

    @Override
    public DemandDepositAccount get(long accountNumber) {
        return demandDepositAccountServiceClient.get(accountNumber).toDemandDepositAccount();
    }
}
