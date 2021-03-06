package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.dto.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("card-service")
public interface CardServiceClient {

    @GetMapping("/api/v1/card/{id}")
    CardDto get(@PathVariable UUID id);

}
