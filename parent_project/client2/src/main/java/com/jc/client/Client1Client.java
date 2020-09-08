package com.jc.client;

import com.jc.client.impl.Client1ClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "client1", fallback = Client1ClientImpl.class)
public interface Client1Client {

    @RequestMapping("/test/test1")
    public String getUserInfo();

}
