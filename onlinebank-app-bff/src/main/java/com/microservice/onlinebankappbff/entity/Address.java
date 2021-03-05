package com.microservice.onlinebankappbff.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private int id;
    private String country;
    private String city;
    private String district;
    private String street;
    private int zipCode;
}
