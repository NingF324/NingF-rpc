package com.ningf.ningfrpc.server;

import io.vertx.core.Vertx;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午8:02
 */
public class VertxHttpServer implements HttpServer {
    public void doStart(int port) {
        //创建Vert.x实例
        Vertx vertx = Vertx.vertx();
        //创建http服务器
        io.vertx.core.http.HttpServer server=vertx.createHttpServer();

        //监听窗口处理请求
        server.requestHandler(new HttpServerHandler());

        //启动服务器并监听端口
        server.listen(port,result ->{
            if(result.succeeded()){
                System.out.println("Server is now listening on port: "+port);
            }else {
                System.err.println("Failed to start server: "+result.cause());
            }
        });
    }
}
