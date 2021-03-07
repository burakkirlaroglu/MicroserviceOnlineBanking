package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.SavingsAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("account-service")
public interface SavingsAccountServiceClient {
    @GetMapping("/api/v1/savings/{accountNumber}")
    SavingsAccountDto get(@PathVariable("accountNumber") long accountNumber);

    @GetMapping("/api/v1/savings/customer/{customerTC}")
    List<SavingsAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC);
}
