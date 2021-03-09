package com.microservice.onlinebank.accountservice.controller;

import com.microservice.onlinebank.accountservice.dto.DemandDepositAccountDto;
import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;
import com.microservice.onlinebank.accountservice.service.abstrct.DemandDepositAccountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DemandDepositAccountController {
    private final DemandDepositAccountService demandDepositAccountService;

    public DemandDepositAccountController(DemandDepositAccountService demandDepositAccountService) {
        this.demandDepositAccountService = demandDepositAccountService;
    }

    @PostMapping("/demand")
    @ResponseStatus(HttpStatus.CREATED)
    public DemandDepositAccountDto create(@RequestBody DemandDepositAccountDto demandDepositAccountDto) {
        return demandDepositAccountService.create(demandDepositAccountDto.toDemandDepositAccount()).toDemandDepositAccountDto();
    }

    @GetMapping("/demand/{accountNumber}")
    public DemandDepositAccountDto get(@PathVariable("accountNumber") long accountNumber) {
        return demandDepositAccountService.get(accountNumber).toDemandDepositAccountDto();
    }

    @GetMapping("demands/customer/{customerTC}")
    public List<DemandDepositAccountDto> getAccountByCustomerTC(@PathVariable("customerTC") long customerTC) {
        try {
            return demandDepositAccountService.getAccountsByCustomerTC(customerTC).stream()
                    .map(DemandDepositAccount::toDemandDepositAccountDto)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/demand/account/{accountIBAN}")
    public DemandDepositAccountDto getAccountByIBAN(@PathVariable("accountIBAN") String accountIBAN) {
        try {
            return demandDepositAccountService.getAccountByIBAN(accountIBAN).toDemandDepositAccountDto();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping(value = "/demands", params = {"page", "size"})
    public List<DemandDepositAccountDto> getAll(@Min(value = 0) @RequestParam("page") int page, @Min(value = 1) @RequestParam("size") int size) {
        return demandDepositAccountService.getAccounts(PageRequest.of(page, size)).stream()
                .map(DemandDepositAccount::toDemandDepositAccountDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/demand/{demandDepositAccountIBAN}/transfer/{savingsAccountIBAN}")
    public DemandDepositAccountDto differentAccountsBetweenMoneyTransfer(@PathVariable("demandDepositAccountIBAN") String demandDepositAccountIBAN,
                                                                         @PathVariable("savingsAccountIBAN") String savingsAccountIBAN,
                                                                         @RequestParam("money") int money,
                                                                         @RequestParam("convertMoney") int convertMoney) {
        return demandDepositAccountService.differentAccountsBetweenMoneyTransfer(demandDepositAccountIBAN, savingsAccountIBAN, money, convertMoney).toDemandDepositAccountDto();
    }

    @PutMapping("/demand/update")
    public DemandDepositAccountDto update(@RequestBody DemandDepositAccountDto demandDepositAccountDto) {
        return demandDepositAccountService.update(demandDepositAccountDto.toDemandDepositAccount()).toDemandDepositAccountDto();
    }

    @DeleteMapping("/demand/delete/{accountNumber}")
    public String delete(@PathVariable("accountNumber") long accountNumber) {
        try {
            return demandDepositAccountService.delete(accountNumber);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
