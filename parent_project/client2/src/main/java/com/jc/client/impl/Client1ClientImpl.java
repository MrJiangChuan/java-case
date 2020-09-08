package com.jc.client.impl;

import com.jc.client.Client1Client;
import org.springframework.stereotype.Component;

@Component
public class Client1ClientImpl implements Client1Client {
    @Override
    public String getUserInfo() {
        return "熔断器触发了";
    }
}
