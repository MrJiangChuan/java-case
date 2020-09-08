package com.jc.controller;

import com.jc.client.Client1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Client1Client remoteCall;

    @RequestMapping("/info")
    public String getInfo(){
        String userInfo = remoteCall.getUserInfo();
        return userInfo;
    }
}
