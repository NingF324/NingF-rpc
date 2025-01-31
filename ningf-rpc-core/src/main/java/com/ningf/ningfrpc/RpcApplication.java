package com.ningf.ningfrpc;

import com.ningf.ningfrpc.config.RpcConfig;
import com.ningf.ningfrpc.constant.RpcConstant;
import com.ningf.ningfrpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/23 上午9:16
 */
@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}",newRpcConfig.toString());
    }

    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    public static RpcConfig getRpcConfig() {
        if(rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if(rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
