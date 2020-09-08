package com.jc.mapper;

import com.jc.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> findAll();

    Account findOneById(Integer id);

    void insert(Account account);

    void update(Account account);

    void delete(Integer id);
}
