package com.microservice.onlinebankappbff.controller;

import com.microservice.onlinebankappbff.dto.CustomerDto;
import com.microservice.onlinebankappbff.entity.Customer;
import com.microservice.onlinebankappbff.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService<Customer> customerService;

    public CustomerController(CustomerService<Customer> customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{customerTC}")
    public CustomerDto get(@PathVariable("customerTC") long customerTC) {
        return customerService.get(customerTC).toCustomerDto();
    }
}
