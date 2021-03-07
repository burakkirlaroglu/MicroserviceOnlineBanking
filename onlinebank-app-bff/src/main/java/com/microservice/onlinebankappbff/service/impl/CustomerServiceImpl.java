package com.microservice.onlinebankappbff.service.impl;

import com.microservice.onlinebankappbff.client.CardServiceClient;
import com.microservice.onlinebankappbff.client.CustomerServiceClient;
import com.microservice.onlinebankappbff.dto.CustomerDto;
import com.microservice.onlinebankappbff.entity.Card;
import com.microservice.onlinebankappbff.entity.Customer;
import com.microservice.onlinebankappbff.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private final CustomerServiceClient customerServiceClient;
    private final CardServiceClient cardServiceClient;

    public CustomerServiceImpl(CustomerServiceClient customerServiceClient, CardServiceClient cardServiceClient) {
        this.customerServiceClient = customerServiceClient;
        this.cardServiceClient = cardServiceClient;
    }

    @Override
    public Customer get(long tc) {
        CustomerDto customerDto = customerServiceClient.get(tc);
        List<Card> cards = cardServiceClient.get(tc);
        customerDto.setCards(cards);
        return customerDto.toCustomer();
    }
}
