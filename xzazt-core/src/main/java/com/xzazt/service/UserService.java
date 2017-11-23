package com.xzazt.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String, Object>> getUser();

    int checkUser(Map<String,Object> params);
}
