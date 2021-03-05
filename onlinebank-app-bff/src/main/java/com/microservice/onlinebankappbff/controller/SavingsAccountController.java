package com.microservice.onlinebankappbff.controller;

import com.microservice.onlinebankappbff.dto.SavingsAccountDto;
import com.microservice.onlinebankappbff.service.abstrct.SavingsAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SavingsAccountController {
    private final SavingsAccountService savingsAccountService;

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @GetMapping("/savings/{accountNumber}")
    public SavingsAccountDto get(@PathVariable("accountNumber") long accountNumber) {
        return savingsAccountService.get(accountNumber).toSavingsAccountDto();
    }
}
