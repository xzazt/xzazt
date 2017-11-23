package com.xzazt.service.impl;

import com.xzazt.dao.UserDao;
import com.xzazt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public List<Map<String, Object>> getUser() {
        return userDao.getUser();
    }

    public int checkUser(Map<String, Object> params) {
        return userDao.getLogin(params);
    }
}
