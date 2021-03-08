package com.microservice.onlinebank.accountservice.repository;


import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandDepositAccountRepository extends MongoRepository<DemandDepositAccount, Long> {
    Page<DemandDepositAccount> findAll(Pageable pageable);

    List<DemandDepositAccount> getDemandDepositAccountsByCustomerTC(long tc);

    DemandDepositAccount getDemandDepositAccountsByAccountIban(String accountIBAN);
}
