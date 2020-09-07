package com.xzy.busness.impl;

import com.github.pagehelper.PageHelper;
import com.xzy.busness.UserService;
import com.xzy.dao.UserMapper;
import com.xzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> loadAllUser(int page, int count) {
        PageHelper.startPage(page, count);
        return userMapper.loadAllUser();
    }
}
