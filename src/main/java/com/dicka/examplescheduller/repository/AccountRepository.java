package com.dicka.examplescheduller.repository;

import com.dicka.examplescheduller.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String>{

    List<Account> findAccountByFirstname(String firstname);
}
