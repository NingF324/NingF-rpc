package com.ningf.example.provider;

import com.ningf.example.common.model.User;
import com.ningf.example.common.service.UserService;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午7:45
 */
public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名："+user.getName());
        return user;
    }
}
