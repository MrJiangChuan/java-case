package com.jc.service.impl;

import com.jc.service.UserService;

public class UserServiceImpl implements UserService {
    public String find() {
        System.out.println("find");
//        int a = 1/0;
        return null;
    }

    public void insert(int i) {
        System.out.println("insert");
    }

    public int update(int i) {
        System.out.println("update");
        return 0;
    }

    public void delete() {
        System.out.println("delete");
    }
}
