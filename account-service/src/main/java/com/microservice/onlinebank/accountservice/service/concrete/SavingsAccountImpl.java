package com.microservice.onlinebank.accountservice.service.concrete;

import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;
import com.microservice.onlinebank.accountservice.entity.SavingsAccount;
import com.microservice.onlinebank.accountservice.repository.SavingsAccountRepository;
import com.microservice.onlinebank.accountservice.service.abstrct.SavingsAccountService;
import com.microservice.onlinebank.accountservice.utility.generate.account.Account;
import com.microservice.onlinebank.accountservice.utility.generate.iban.Iban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SavingsAccountImpl implements SavingsAccountService {
    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountImpl(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;

    }

    @Override
    public SavingsAccount create(SavingsAccount savingsAccount) {
        String accountNumber = Account.generateAccount.get();
        savingsAccount.setAccountNumber(Long.parseLong(accountNumber));
        savingsAccount.setAccountIban(Iban.generateIban.apply(accountNumber));
        return savingsAccountRepository.save(savingsAccount);
    }


    @Override
    public SavingsAccount get(long accountNumber) {
        return savingsAccountRepository.findById(accountNumber)
                .orElseThrow(() -> (new ResponseStatusException(HttpStatus.NOT_FOUND, "Account is not found.")));
    }

    @Override
    public String delete(long accountNumber) {
        SavingsAccount savingsAccount = get(accountNumber);
        if (savingsAccount.getAccountBalance() == 0) {
            savingsAccountRepository.delete(savingsAccount);
            return savingsAccount.getAccountNumber() + " number account was deleted.";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Have money in your account");
        }
    }

    @Override
    public Page<SavingsAccount> getAccounts(Pageable pageable) {
        return savingsAccountRepository.findAll(pageable);
    }

    @Override
    public List<SavingsAccount> getAccountsByCustomerTC(long tc) {
        List<SavingsAccount> savingsAccounts = savingsAccountRepository
                .getSavingsAccountsByCustomerTC(tc);
        if (!savingsAccounts.isEmpty()) {
            return savingsAccounts;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer have not accounts");
        }
    }

    @Override
    public SavingsAccount getAccountByIBAN(String accountIBAN) {
        SavingsAccount savingsAccount = savingsAccountRepository.getSavingsAccountByAccountIban(accountIBAN);
        if (savingsAccount != null) {
            return savingsAccount;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account is not found");
        }
    }

    @Override
    public SavingsAccount update(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }
}
