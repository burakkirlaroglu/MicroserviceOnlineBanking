package com.microservice.onlinebank.accountservice.utility.generate.account;

import java.util.Random;
import java.util.function.Supplier;

public final class Account {
    private Account() {
    }

    public static final Supplier<String> generateAccount = () -> {
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append("8500");
        for (int i = 0; i < 12; i++) {
            accountNumber.append(new Random().nextInt(10));
        }
        return accountNumber.toString();
    };
}