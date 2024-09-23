package com.ningf.example.provider;

import com.ningf.example.common.service.UserService;
import com.ningf.ningfrpc.RpcApplication;
import com.ningf.ningfrpc.registry.LocalRegistry;
import com.ningf.ningfrpc.server.HttpServer;
import com.ningf.ningfrpc.server.VertxHttpServer;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/23 上午9:27
 */
public class ProviderExample {
    public static void main(String[] args) {
        RpcApplication.init();
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}