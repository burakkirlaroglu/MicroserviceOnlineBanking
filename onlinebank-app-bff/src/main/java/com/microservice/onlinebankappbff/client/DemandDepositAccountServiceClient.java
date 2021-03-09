package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("account-service")
public interface DemandDepositAccountServiceClient {
    @GetMapping("/api/v1/demand/{accountNumber}")
    DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber);

    @GetMapping("/api/v1/demand/account/{accountIBAN}")
    DemandDepositAccountDto getAccountByIBAN(@PathVariable("accountIBAN") String accountIBAN);

    @PutMapping("/api/v1/demand/{demandDepositAccountIBAN}/transfer/{savingsAccountIBAN}")
    DemandDepositAccountDto differentAccountsBetweenMoneyTransfer(@PathVariable("demandDepositAccountIBAN") String demandDepositAccountIBAN,
                                                                  @PathVariable("savingsAccountIBAN") String savingsAccountIBAN,
                                                                  @RequestParam("money") int money,
                                                                  @RequestParam("convertMoney") int convertMoney);

    @PutMapping("/api/v1/demand/update")
    DemandDepositAccountDto update(@RequestBody DemandDepositAccountDto demandDepositAccountDto);

    @GetMapping("/api/v1/demands/customer/{customerTC}")
    List<DemandDepositAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC);
}
