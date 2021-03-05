package com.microservice.onlinebank.accountservice.service.concrete;

import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;
import com.microservice.onlinebank.accountservice.repository.DemandDepositAccountRepository;
import com.microservice.onlinebank.accountservice.service.abstrct.DemandDepositAccountService;
import com.microservice.onlinebank.accountservice.utility.generate.account.Account;
import com.microservice.onlinebank.accountservice.utility.generate.iban.Iban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DemandDepositAccountImpl implements DemandDepositAccountService {
    private final DemandDepositAccountRepository demandDepositAccountRepository;

    public DemandDepositAccountImpl(DemandDepositAccountRepository demandDepositAccountRepository) {
        this.demandDepositAccountRepository = demandDepositAccountRepository;

    }

    @Override
    public DemandDepositAccount create(DemandDepositAccount demandDepositAccount) {
        String accountNumber = Account.generateAccount.get();
        demandDepositAccount.setAccountNumber(Long.parseLong(accountNumber));
        demandDepositAccount.setAccountIban(Iban.generateIban.apply(accountNumber));
        return demandDepositAccountRepository.save(demandDepositAccount);
    }


    @Override
    public DemandDepositAccount get(long accountNumber) {
        return demandDepositAccountRepository.findById(accountNumber)
                .orElseThrow(() -> (new ResponseStatusException(HttpStatus.NOT_FOUND, "Account is not found")));
    }

    @Override
    public String delete(long accountNumber) {
        DemandDepositAccount demandDepositAccount = get(accountNumber);
        if (demandDepositAccount.getAccountBalance() == 0) {
            demandDepositAccountRepository.delete(demandDepositAccount);
            return demandDepositAccount.getAccountNumber() + " number account was deleted.";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Have money in your account");
        }
    }

    @Override
    public Page<DemandDepositAccount> getAccounts(Pageable pageable) {
        return demandDepositAccountRepository.findAll(pageable);
    }

}
