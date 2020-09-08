package com.jc;

import com.jc.entity.Account;
import com.jc.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	void findAll() {
		List<Account> all = accountRepository.findAll();
		for (Account account : all) {
			System.out.println(account);
		}

	}

	@Test
	void findById() {

		Optional<Account> byId = accountRepository.findById(1);
		System.out.println(byId.get());
	}

	@Test
	void save() {
		Account account = accountRepository.save(new Account(null, "张三", 1220f));
		System.out.println(account);
	}

	@Test
	void update() {
		Account account = accountRepository.save(new Account(9, "张三", 1f));
		System.out.println(account);
	}

	@Test
	void delete() {
		accountRepository.deleteById(9);
	}


}
