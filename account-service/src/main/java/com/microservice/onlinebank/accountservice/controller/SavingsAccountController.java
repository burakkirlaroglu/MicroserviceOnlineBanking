package com.microservice.onlinebank.accountservice.controller;

import com.microservice.onlinebank.accountservice.dto.DemandDepositAccountDto;
import com.microservice.onlinebank.accountservice.dto.SavingsAccountDto;
import com.microservice.onlinebank.accountservice.entity.SavingsAccount;
import com.microservice.onlinebank.accountservice.service.abstrct.SavingsAccountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
public class SavingsAccountController {
    private final SavingsAccountService savingsAccountService;

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccountDto create(@RequestBody SavingsAccountDto savingsAccountDto) {
        return savingsAccountService.create(savingsAccountDto.toSavingsAccount()).toSavingsAccountDto();
    }

    @GetMapping("/savings/{accountNumber}")
    public SavingsAccountDto get(@PathVariable("accountNumber") long accountNumber) {
        return savingsAccountService.get(accountNumber).toSavingsAccountDto();
    }

    @GetMapping("savings/customer/{customerTC}")
    public List<SavingsAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC) {
        try {
            return savingsAccountService.getAccountsByCustomerTC(customerTC).stream()
                    .map(SavingsAccount::toSavingsAccountDto)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping(value = "/all/savings", params = {"page", "size"})
    public List<SavingsAccountDto> getAll(@Min(value = 0) @RequestParam("page") int page, @Min(value = 1) @RequestParam("size") int size) {
        return savingsAccountService.getAccounts(PageRequest.of(page, size)).stream()
                .map(SavingsAccount::toSavingsAccountDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/savings/delete/{accountNumber}")
    public String delete(@PathVariable("accountNumber") long accountNumber) {
        try {
            return savingsAccountService.delete(accountNumber);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
