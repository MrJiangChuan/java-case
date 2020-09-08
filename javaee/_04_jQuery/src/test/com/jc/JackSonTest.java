package com.jc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jc.entity.User;

import java.io.IOException;
import java.util.Date;

public class JackSonTest {

    @org.junit.Test
    public void test1() throws IOException {

        User tom = new User("Tom", 21,new Date());

        ObjectMapper objectMapper = new ObjectMapper();

        String string = objectMapper.writeValueAsString(tom);
        User user = objectMapper.readValue(string, User.class);

        System.out.println(string);
        System.out.println(user);
    }

}
