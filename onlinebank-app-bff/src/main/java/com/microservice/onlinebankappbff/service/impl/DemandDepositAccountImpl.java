package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.DemandDepositAccountServiceClient;
import com.microservice.onlinebankappbff.client.SavingsAccountServiceClient;
import com.microservice.onlinebankappbff.client.TransferServiceClient;
import com.microservice.onlinebankappbff.entity.DemandDepositAccount;
import com.microservice.onlinebankappbff.entity.SavingsAccount;
import com.microservice.onlinebankappbff.entity.Transfer;
import com.microservice.onlinebankappbff.service.DemandDepositAccountService;
import org.springframework.stereotype.Service;

@Service
public class DemandDepositAccountImpl implements DemandDepositAccountService {
    private final DemandDepositAccountServiceClient demandDepositAccountServiceClient;
    private final SavingsAccountServiceClient savingsAccountServiceClient;
    private final TransferServiceClient transferServiceClient;

    public DemandDepositAccountImpl(DemandDepositAccountServiceClient demandDepositAccountServiceClient, SavingsAccountServiceClient savingsAccountServiceClient, TransferServiceClient transferServiceClient) {
        this.demandDepositAccountServiceClient = demandDepositAccountServiceClient;
        this.savingsAccountServiceClient = savingsAccountServiceClient;
        this.transferServiceClient = transferServiceClient;
    }

    @Override
    public DemandDepositAccount get(long accountNumber) {
        return demandDepositAccountServiceClient.get(accountNumber).toDemandDepositAccount();
    }

    @Override
    public DemandDepositAccount transferMoney(long demandDepositAccountNumber, long savingsAccountNumber, int money) {
        DemandDepositAccount demandDepositAccount = demandDepositAccountServiceClient.get(demandDepositAccountNumber).toDemandDepositAccount();
        SavingsAccount savingsAccount = savingsAccountServiceClient.get(savingsAccountNumber).toSavingsAccount();
        double convertMoney = transferServiceClient.getConvertMoney(demandDepositAccount.getAccountCurrency(), savingsAccount.getAccountCurrency(), money);
        return demandDepositAccountServiceClient.differentAccountsBetweenMoneyTransfer(demandDepositAccount.getAccountIban(),
                savingsAccount.getAccountIban(), money, (int) convertMoney).toDemandDepositAccount();
    }

    @Override
    public DemandDepositAccount accountBetweenMoneyTransfer(Transfer transfer) {
        DemandDepositAccount demandDepositAccount = demandDepositAccountServiceClient.getAccountByIBAN(transfer.getFromAccountIBAN()).toDemandDepositAccount();
        SavingsAccount savingsAccount = savingsAccountServiceClient.getAccountByIBAN(transfer.getToAccountIBAN()).toSavingsAccount();
        double convertMoney = transferServiceClient.getConvertMoney(demandDepositAccount.getAccountCurrency(), savingsAccount.getAccountCurrency(), transfer.getMoney());
        savingsAccount.setAccountBalance(savingsAccount.getAccountBalance() + (int) convertMoney);
        demandDepositAccount.setAccountBalance(demandDepositAccount.getAccountBalance() - transfer.getMoney());
        savingsAccountServiceClient.update(savingsAccount.toSavingsAccountDto());
        return demandDepositAccountServiceClient.update(demandDepositAccount.toDemandDepositAccountDto()).toDemandDepositAccount();
    }
}
