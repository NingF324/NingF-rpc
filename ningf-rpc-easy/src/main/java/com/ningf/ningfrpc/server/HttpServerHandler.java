package com.ningf.ningfrpc.server;

import com.ningf.ningfrpc.model.RpcRequest;
import com.ningf.ningfrpc.model.RpcResponse;
import com.ningf.ningfrpc.registry.LocalRegistry;
import com.ningf.ningfrpc.serializer.JdkSerializer;
import com.ningf.ningfrpc.serializer.Serializer;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/19 上午10:40
 */
public class HttpServerHandler implements Handler<HttpServerRequest> {

    @Override
    public void handle(HttpServerRequest request) {
        final Serializer serializer =new JdkSerializer();
        System.out.println("Received request: "+request.method()+" "+request.uri());

        //异步处理http请求
        request.bodyHandler(body -> {
            byte[] bytes = body.getBytes();
            RpcRequest rpcRequest = null;
            try {
                rpcRequest = serializer.deserialize(bytes,RpcRequest.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //响应结果对象
            RpcResponse rpcResponse = new RpcResponse();
            if(rpcRequest == null) {
                rpcResponse.setMessage("rpcRequest is null");
                doResponse(request,rpcResponse,serializer);
                return;
            }

            try {
                //获取服务实现类，通过反射调用
                Class<?> implClass = LocalRegistry.get(rpcRequest.getMethodName());
                Method method = implClass.getMethod(rpcRequest.getMethodName(),rpcRequest.getParameterTypes());
                Object result = method.invoke(implClass.newInstance(),rpcRequest.getArgs());
                //封装返回结果
                rpcResponse.setData(result);
                rpcResponse.setDataType(method.getReturnType());
                rpcResponse.setMessage("ok");
            } catch (Exception e) {
                e.printStackTrace();
                rpcResponse.setMessage(e.getMessage());
                rpcResponse.setException(e);
            }
            doResponse(request,rpcResponse,serializer);
        });
    }
    void doResponse(HttpServerRequest request,RpcResponse rpcResponse,Serializer serializer) {
        HttpServerResponse httpServerResponse = request.response()
                .putHeader("content-type","application/json");
        try {
            byte[] serialized = serializer.serialize(rpcResponse);
            httpServerResponse.end(Buffer.buffer(serialized));
        } catch (IOException e) {
            e.printStackTrace();
            httpServerResponse.end(Buffer.buffer());
        }
    }
}