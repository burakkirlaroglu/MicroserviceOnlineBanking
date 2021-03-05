package com.microservice.onlinebank.accountservice.utility.generate.iban;

import java.util.function.Function;

public final class Iban {
    private Iban() {
    }

    public static final Function<String, String> generateIban = (accountNumber -> "TR30000571" + accountNumber);
}
