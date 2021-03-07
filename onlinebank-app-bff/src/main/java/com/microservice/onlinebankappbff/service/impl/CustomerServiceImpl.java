package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.CardServiceClient;
import com.microservice.onlinebankappbff.client.CustomerServiceClient;
import com.microservice.onlinebankappbff.client.DemandDepositAccountServiceClient;
import com.microservice.onlinebankappbff.client.SavingsAccountServiceClient;
import com.microservice.onlinebankappbff.dto.CustomerDto;
import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import com.microservice.onlinebankappbff.dto.SavingsAccountDto;
import com.microservice.onlinebankappbff.entity.Card;
import com.microservice.onlinebankappbff.entity.Customer;
import com.microservice.onlinebankappbff.entity.DemandDepositAccount;
import com.microservice.onlinebankappbff.entity.SavingsAccount;
import com.microservice.onlinebankappbff.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private final CustomerServiceClient customerServiceClient;
    private final CardServiceClient cardServiceClient;
    private final DemandDepositAccountServiceClient demandDepositAccountServiceClient;
    private final SavingsAccountServiceClient savingsAccountServiceClient;

    public CustomerServiceImpl(CustomerServiceClient customerServiceClient, CardServiceClient cardServiceClient, DemandDepositAccountServiceClient demandDepositAccountServiceClient, SavingsAccountServiceClient savingsAccountServiceClient) {
        this.customerServiceClient = customerServiceClient;
        this.cardServiceClient = cardServiceClient;
        this.demandDepositAccountServiceClient = demandDepositAccountServiceClient;
        this.savingsAccountServiceClient = savingsAccountServiceClient;
    }

    @Override
    public Customer get(long tc) {
        CustomerDto customerDto = customerServiceClient.get(tc);
        List<Card> cards = cardServiceClient.get(tc);
        List<DemandDepositAccountDto> demandDepositAccounts = demandDepositAccountServiceClient.getAccountByCustomerTC(tc);
        List<SavingsAccountDto> savingsAccounts = savingsAccountServiceClient.getAccountByCustomerTC(tc);
        customerDto.setCards(cards);
        customerDto.setDemandDepositAccounts(demandDepositAccounts.stream().map(DemandDepositAccountDto::toDemandDepositAccount).collect(Collectors.toList()));
        customerDto.setSavingsAccounts(savingsAccounts.stream().map(SavingsAccountDto::toSavingsAccount).collect(Collectors.toList()));
        return customerDto.toCustomer();
    }
}
