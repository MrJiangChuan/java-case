package com.jc;

import com.jc.entity.Account;
import com.jc.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class RedisApplicationTests {

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Test
	void findAll() {

		List<Account> all = accountMapper.findAll();
		for (Account account : all) {
			System.out.println(account);
		}
	}


	@Test
	void redisSave() {

		redisTemplate.opsForValue().set("user2","姜川");
		System.out.println(1);
	}

	@Test
	void redisGet() {

		String user = redisTemplate.opsForValue().get("user2");
		System.out.println(user);
	}


}
