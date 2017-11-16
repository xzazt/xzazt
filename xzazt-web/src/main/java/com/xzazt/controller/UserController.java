package com.xzazt.controller;

import com.xzazt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUser")
    public ModelAndView getUser(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> user = userService.getUser();
        System.out.println(user);
        request.getSession().setAttribute("user",user);
        /*mv.addObject("user",user);*/
        mv.setViewName("login");
        return mv;
    }

}
