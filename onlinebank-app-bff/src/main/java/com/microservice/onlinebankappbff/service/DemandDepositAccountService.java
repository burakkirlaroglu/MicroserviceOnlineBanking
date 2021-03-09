package com.microservice.onlinebankappbff.service;


import com.microservice.onlinebankappbff.dto.TransferDto;
import com.microservice.onlinebankappbff.entity.DemandDepositAccount;
import com.microservice.onlinebankappbff.entity.Transfer;


public interface DemandDepositAccountService extends AccountService<DemandDepositAccount> {
    DemandDepositAccount transferMoney(long demandDepositAccountNumber, long savingsAccountNumber, int money);

    DemandDepositAccount accountBetweenMoneyTransfer(Transfer transfer);
}
