package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerServiceClient {
    @GetMapping("/api/v1/customer/{customerTC}")
    CustomerDto get(@PathVariable("customerTC") long customerTC);
}
