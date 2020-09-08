package com.jc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigApplication.class, args);
	}

	@Bean(name = "strings")
	String[] createStringArrays(){
		List<String> list = new ArrayList<>();
		list.add("江苏");
		list.add("北京");
		list.add("上海");
		list.add("天津");
		String[] strings = new String[list.size()];
		return list.toArray(strings);
	}


}
