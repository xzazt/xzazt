package com.xzazt;

import com.xzazt.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class loginRealm extends AuthorizingRealm{

    private UserService userService;

    @Override
    public String getName() {
        return "loginRealm";
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证回调函数，登录信息和用户验证信息验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        String password = new  String((char[]) authenticationToken.getPrincipal());
        Map<String,Object> params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        int i = userService.checkUser(params);
        if(i == 0){
            return null;
        }

        return new SimpleAuthenticationInfo(username,password,getName());
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
