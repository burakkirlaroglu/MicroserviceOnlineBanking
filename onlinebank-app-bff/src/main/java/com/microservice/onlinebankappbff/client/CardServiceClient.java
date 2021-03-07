package com.microservice.onlinebankappbff.client;

import com.microservice.onlinebankappbff.entity.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("card-service")
public interface CardServiceClient {

    @GetMapping("/api/v1/card/{tc}")
    List<Card> get(@PathVariable long tc);

}
