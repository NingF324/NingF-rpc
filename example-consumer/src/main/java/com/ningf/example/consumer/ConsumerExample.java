package com.ningf.example.consumer;

import com.ningf.ningfrpc.config.RpcConfig;
import com.ningf.ningfrpc.utils.ConfigUtils;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/23 上午9:25
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpc);
    }
}
