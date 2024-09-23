package com.ningf.example.consumer;

import com.ningf.example.common.service.UserService;
import com.ningf.ningfrpc.proxy.ServiceProxyFactory;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午7:48
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

    }
}
