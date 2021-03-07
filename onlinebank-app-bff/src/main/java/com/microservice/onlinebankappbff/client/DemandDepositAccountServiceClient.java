package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("account-service")
public interface DemandDepositAccountServiceClient {
    @GetMapping("/api/v1/demand/{accountNumber}")
    DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber);

    @GetMapping("/api/v1/demands/customer/{customerTC}")
    List<DemandDepositAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC);
}
