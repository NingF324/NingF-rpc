package com.ningf.ningfrpc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/19 上午10:24
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RpcResponse implements Serializable {
    private Object data;
    private Class<?> dataType;
    //响应信息
    private String message;
    //错误信息
    private Exception exception;
}
