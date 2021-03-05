package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.SavingsAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface SavingsAccountServiceClient {
    @GetMapping("/api/v1/savings/{accountNumber}")
    SavingsAccountDto get(@PathVariable("accountNumber") long accountNumber);
}
