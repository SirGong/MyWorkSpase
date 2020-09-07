package com.xzy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class User {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username ,
                        @RequestParam("password") String password,
                        Map<String,Object> map , HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误！");
            return "login";
        }
    }
}
