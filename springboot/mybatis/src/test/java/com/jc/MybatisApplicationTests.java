package com.jc;

import com.jc.entity.Account;
import com.jc.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.dc.pr.PRError;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

	@Autowired
	private AccountMapper accountMapper;

	@Test
	void findAll() {
		List<Account> accounts = accountMapper.findAll();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	@Test
	void findOne() {
		Account oneById = accountMapper.findOneById(1);
		System.out.println(oneById);
	}

	@Test
	void insert() {
		accountMapper.insert(new Account(null,"姜川",1200f));
	}

	@Test
	void update() {
		accountMapper.update(new Account(6,"Tom",120f));
	}

	@Test
	void delete(){
		accountMapper.delete(7);
	}
}
