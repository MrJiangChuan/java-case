package com.jc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Client1 {
    public static void main(String[] args) {
        SpringApplication.run(Client1.class,args);
    }
}
