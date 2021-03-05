package com.microservice.onlinebankappbff.service.concrete;

import com.microservice.onlinebankappbff.client.CustomerServiceClient;
import com.microservice.onlinebankappbff.dto.CustomerDto;
import com.microservice.onlinebankappbff.entity.Customer;
import com.microservice.onlinebankappbff.service.abstrct.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
    private final CustomerServiceClient customerServiceClient;

    public CustomerServiceImpl(CustomerServiceClient customerServiceClient) {
        this.customerServiceClient = customerServiceClient;
    }

    @Override
    public Customer get(long tc) {
        CustomerDto customerDto = customerServiceClient.get(tc);
        return customerDto.toCustomer();
    }
}
