package com.microservice.onlinebank.accountservice.repository;

import com.microservice.onlinebank.accountservice.entity.SavingsAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Long> {
    Page<SavingsAccount> findAll(Pageable pageable);

    SavingsAccount getSavingsAccountByCustomerTC(long tc);
}
