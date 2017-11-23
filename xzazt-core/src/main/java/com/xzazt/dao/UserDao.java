package com.xzazt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDao {

    @Autowired
    @Qualifier("mybatisDao")
    private MybatisDao mybatisDao;

    public List<Map<String, Object>> getUser(){
        List<Map<String, Object>> list = mybatisDao.get("userMapper.getUser");
        return list;
    }

    public int getLogin(Map<String,Object> params){
        int count = mybatisDao.count("userMapper.getLogin", params);
        return count;
    }


}
