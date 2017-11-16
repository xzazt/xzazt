package com.xzazt.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("mybatisDao")
public class MybatisDao {

    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public List<Map<String,Object>> get(String key){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String,Object>> list = sqlSession.selectList(key);
        return list;
    }
}
