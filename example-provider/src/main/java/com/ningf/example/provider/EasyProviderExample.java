package com.ningf.example.provider;

import com.ningf.example.common.service.UserService;
import com.ningf.ningfrpc.registry.LocalRegistry;
import com.ningf.ningfrpc.server.HttpServer;
import com.ningf.ningfrpc.server.VertxHttpServer;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午7:47
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        //启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
