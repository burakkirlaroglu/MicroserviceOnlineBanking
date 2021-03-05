package com.microservice.onlinebankappbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OnlinebankAppBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinebankAppBffApplication.class, args);
    }

}
