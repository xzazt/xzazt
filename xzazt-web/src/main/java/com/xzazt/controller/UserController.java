package com.xzazt.controller;

import com.alibaba.fastjson.JSON;
import com.xzazt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        List<Map<String, Object>> user = userService.getUser();
        String s = JSON.toJSONString(user);
        return s;
    }


    @RequestMapping(value = "/getUser2")
    public ModelAndView getUser2(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> user = userService.getUser();
        System.out.println(user);
        request.getSession().setAttribute("user",user);
        /*mv.addObject("user",user);*/
        mv.setViewName("login");
        return mv;
    }

}
