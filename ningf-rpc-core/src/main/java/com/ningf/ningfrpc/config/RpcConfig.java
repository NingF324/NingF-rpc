package com.ningf.ningfrpc.config;

import lombok.Data;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/23 上午9:04
 */

@Data
public class RpcConfig {
    private String name = "ningf-rpc";

    private String version = "1.0";

    private String serverHost = "localhost";

    private Integer serverPort = 8080;
}
