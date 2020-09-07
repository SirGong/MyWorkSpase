package com.xzy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstController {
    /**
     *  / ：代表当前项目开始，处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("请求收到了");
        //自动与配置的视图解析器进行拼串
        return "success";
    }
}
