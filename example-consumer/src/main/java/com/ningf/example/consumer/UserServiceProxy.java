package com.ningf.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ningf.example.common.model.User;
import com.ningf.example.common.service.UserService;
import com.ningf.ningfrpc.model.RpcRequest;
import com.ningf.ningfrpc.model.RpcResponse;
import com.ningf.ningfrpc.serializer.JdkSerializer;
import com.ningf.ningfrpc.serializer.Serializer;

import java.io.IOException;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/19 上午11:12
 */
public class UserServiceProxy implements UserService {

    @Override
    public User getUser(User user) {
        Serializer serializer = new JdkSerializer();

        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
