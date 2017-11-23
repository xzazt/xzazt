package com.xzazt.controller;

import com.alibaba.fastjson.JSON;
import com.xzazt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public String doLogin(HttpServletRequest request){
        String status = "123";
        //JSONObject jsonObject = JSON.parseObject(requestBody);
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            status = "success";
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            status = "faild";
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            status = "faild";
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            status = "faild";
        }

        return status;
    }

}
