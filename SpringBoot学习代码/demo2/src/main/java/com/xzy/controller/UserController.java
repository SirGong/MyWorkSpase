package com.xzy.controller;

import com.xzy.busness.UserService;
import com.xzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "loadalluser/{page}/{size}")
    public List<User> loadAllUser(@PathVariable("page") int page,
                                  @PathVariable("size") int count) {
        List<User> list = userService.loadAllUser(page, count);
        return list;
    }
}
