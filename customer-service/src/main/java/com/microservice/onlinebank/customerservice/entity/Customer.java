package com.microservice.onlinebank.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.onlinebank.customerservice.dto.CustomerDto;
import com.microservice.onlinebank.customerservice.utility.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class Customer {
    @Id
    private long customerTC;
    private String customerName;
    private String customerLastname;
    @Enumerated(EnumType.STRING)
    private Gender customerGender;
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Phone Number Ex:+(123)-456-78-90")
    @Length(min = 18, max = 18)
    private String customerPhone;
    private String customerEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate customerBirthDate;
    private boolean isState;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    @JsonIgnore
    private Address address;

    public CustomerDto toCustomerDto() {
        return CustomerDto.builder()
                .customerTC(this.customerTC)
                .customerName(this.customerName)
                .customerLastname(this.customerLastname)
                .customerGender(this.customerGender)
                .customerPhone(this.customerPhone)
                .customerEmail(this.customerEmail)
                .customerBirthDate(this.customerBirthDate)
                .address(this.address)
                .build();
    }
}