package com.microservice.onlinebankappbff.controller;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import com.microservice.onlinebankappbff.service.DemandDepositAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DemandDepositAccountController {
    private final DemandDepositAccountService demandDepositAccountService;

    public DemandDepositAccountController(DemandDepositAccountService demandDepositAccountService) {
        this.demandDepositAccountService = demandDepositAccountService;
    }

    @GetMapping("/demand/{accountNumber}")
    public DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber) {
        return demandDepositAccountService.get(accountNumber).toDemandDepositAccountDto();
    }

    @GetMapping("demand/{accountNumber}/transfer/{savingsAccountNumber}")
    public DemandDepositAccountDto getDifferentAccountsBetweenMoneyTransfer(@PathVariable("accountNumber") long accountNumber,
                                                                            @PathVariable("savingsAccountNumber") long savingsAccountNumber,
                                                                            @RequestParam("money") int money) {
        return demandDepositAccountService.transferMoney(accountNumber, savingsAccountNumber, money).toDemandDepositAccountDto();
    }
}
