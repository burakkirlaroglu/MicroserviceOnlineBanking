package com.microservice.onlinebank.accountservice.service.abstrct;


import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;


public interface DemandDepositAccountService extends AccountService<DemandDepositAccount>{
    DemandDepositAccount differentAccountsBetweenMoneyTransfer(String demandDepositAccountIBAN,String savingsAccountIBAN,int money,int convertMoney);
}
