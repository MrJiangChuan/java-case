package com.jc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterServer.class,args);
    }
}
