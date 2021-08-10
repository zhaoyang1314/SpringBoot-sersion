package com.session2.springsession2.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.session2.springsession2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: wade
 * @Date: 2021/07/15/9:08
 * @qq:1143011510
 * @Description:
 */
@RefreshScope
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/login/{userName}")
    public String login(@PathVariable String userName, HttpServletRequest request, HttpServletResponse response){
        String PASSWORD = loginService.loginInfo(userName);
        Cookie cookie = new Cookie("password1", PASSWORD);
        response.addHeader("passsword",PASSWORD);
        response.addCookie(cookie);
        return PASSWORD;
    }

    @RequestMapping("/getUserName/{userName}")
    public List getUserName(@PathVariable String[] userName){
        List allUserNames = loginService.getUserName(userName);
        redisTemplate.opsForValue().set("userInfo",allUserNames);
        return allUserNames;
    }

    @NacosValue(value="${name}" ,autoRefreshed = true)
   private String name;


    @RequestMapping("/getNacosValue")
    public String getNacosValue(){

        return name;
    }
}
