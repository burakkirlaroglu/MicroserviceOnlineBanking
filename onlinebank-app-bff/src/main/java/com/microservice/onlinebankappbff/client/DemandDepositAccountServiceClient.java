package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface DemandDepositAccountServiceClient {
    @GetMapping("/api/v1/demand/{accountNumber}")
    DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber);
}
