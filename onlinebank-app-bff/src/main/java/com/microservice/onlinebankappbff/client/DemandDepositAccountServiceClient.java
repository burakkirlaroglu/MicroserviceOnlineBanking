package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("account-service")
public interface DemandDepositAccountServiceClient {
    @GetMapping("/api/v1/demand/{accountNumber}")
    DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber);

    @PutMapping("/api/v1/demand/{demandDepositAccountIBAN}/transfer/{savingsAccountIBAN}")
    DemandDepositAccountDto differentAccountsBetweenMoneyTransfer(@PathVariable("demandDepositAccountIBAN") String demandDepositAccountIBAN,
                                                                  @PathVariable("savingsAccountIBAN") String savingsAccountIBAN,
                                                                  @RequestParam("money") int money,
                                                                  @RequestParam("convertMoney") int convertMoney);
    @GetMapping("/api/v1/demands/customer/{customerTC}")
    List<DemandDepositAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC);
}
