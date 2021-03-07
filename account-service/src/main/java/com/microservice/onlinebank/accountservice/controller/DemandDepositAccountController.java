package com.microservice.onlinebank.accountservice.controller;

import com.microservice.onlinebank.accountservice.dto.DemandDepositAccountDto;
import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;
import com.microservice.onlinebank.accountservice.service.abstrct.DemandDepositAccountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
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

    @GetMapping("demand/customer/{customerTC}")
    public DemandDepositAccountDto getAccountByCustomerTC(@PathVariable("customerTC") long customerTC) {
        try {
            return demandDepositAccountService.getAccountByCustomerTC(customerTC).toDemandDepositAccountDto();
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


    @DeleteMapping("/demand/delete/{accountNumber}")
    public String delete(@PathVariable("accountNumber") long accountNumber) {
        try {
            return demandDepositAccountService.delete(accountNumber);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
