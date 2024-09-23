package com.ningf.ningfrpc.serializer;

import java.io.IOException;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/19 上午10:14
 */

//序列化器接口
public interface Serializer {
    <T> byte[] serialize(T object) throws IOException;

    <T> T deserialize(byte[] bytes,Class<T> type) throws IOException;
}
