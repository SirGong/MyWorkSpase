package com.xzy.controller;

import com.xzy.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试获取请求参数
 */
@Controller
public class ParamController {

    @RequestMapping("/handle01")
    public String handle01(@RequestParam("user") String username) {
        System.out.println("获取到的请求参数是：" + username);
        return "success";
    }

    /**
     * 解决乱码
     * 请求乱码：
     *      get请求：修改server.xml中端口处添加URLEncoding="UTF-8"
     *      post请求：在第一次请求之前设置 request.setCharacterEncoding("UTF-8")
     *
     * 响应乱码：
     *
     * @param book
     * @return
     */
    @RequestMapping("/book")
    public String addBook(Book book){
        System.out.println("获取到的数据是：" + book);
        return "success";
    }

}
