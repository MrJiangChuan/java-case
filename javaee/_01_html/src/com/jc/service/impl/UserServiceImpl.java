package com.jc.service.impl;

import com.jc.dao.UserDao;
import com.jc.dao.impl.UserDaoImpl;
import com.jc.entity.User;
import com.jc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean userContains(User user) {
        return userDao.userContains(user);
    }
}
