package com.microservice.onlinebank.accountservice.repository;


import com.microservice.onlinebank.accountservice.entity.DemandDepositAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandDepositAccountRepository extends CrudRepository<DemandDepositAccount,Long> {
    Page<DemandDepositAccount> findAll(Pageable pageable);

    DemandDepositAccount getDemandDepositAccountByCustomerTC(long tc);
}
