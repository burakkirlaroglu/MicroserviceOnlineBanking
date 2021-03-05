package com.microservice.onlinebankappbff.controller;

import com.microservice.onlinebankappbff.dto.DemandDepositAccountDto;
import com.microservice.onlinebankappbff.service.abstrct.DemandDepositAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
