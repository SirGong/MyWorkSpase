package com.xzy.busness;

import com.xzy.entity.User;

import java.util.List;

public interface UserService {
    List<User> loadAllUser(int page, int count);
}
