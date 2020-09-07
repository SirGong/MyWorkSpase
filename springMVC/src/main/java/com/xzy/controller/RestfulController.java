package com.xzy.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class RestfulController {

    @RequestMapping(value = "/getResources/{id}",method = RequestMethod.GET)
    public String getResources(@PathVariable("id") Integer id){
        System.out.println("获取了"+id+"号资源");
        return "success";
    }

    @RequestMapping(value = "/addResources",method = RequestMethod.POST)
    public String addResources(){
        System.out.println("添加了资源");
        return "success";
    }

    @RequestMapping(value = "/updateResources/{id}",method = RequestMethod.PUT)
    public String updateResources(@PathVariable("id") Integer id){
        System.out.println("更新了"+id+"号资源");
        return "success";
    }

    @RequestMapping(value = "/deleteResources/{id}",method = RequestMethod.DELETE)
    public String deleteResources(@PathVariable("id") Integer id){
        System.out.println("删除"+id+"号资源");
        return "success";
    }

/*
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
*/

}
