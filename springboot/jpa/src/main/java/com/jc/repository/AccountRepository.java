package com.jc.repository;

import com.jc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

     List<Account> findAll();

     Optional<Account> findById(Integer id);

     //增、改
     Account save(Account entity);

    void deleteById(Integer integer);
}
