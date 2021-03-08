package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.utility.enums.currency.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@FeignClient("transfer-service")
public interface TransferServiceClient {
    @GetMapping("/api/v1/exchange/{currency}/transfer/{convertCurrency}")
    double getConvertMoney(@NotNull @PathVariable("currency") Currency currency,
                           @NotNull @PathVariable("convertCurrency") Currency convertCurrency,
                           @RequestParam("money") int money);
}
