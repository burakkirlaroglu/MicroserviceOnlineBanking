package com.microservice.onlinebank.customerservice.utility.generate.TC;

import java.util.Random;
import java.util.function.Supplier;

public class TC {
    private TC() {

    }

    public static Supplier<Long> generateTC = () -> {
        StringBuilder builder = new StringBuilder();
        builder.append(1 + new Random().nextInt(8));
        for (int i = 0; i < 11; i++) {
            builder.append(new Random().nextInt(10));
        }
        return Long.valueOf(builder.toString());
    };
}
