package com.ningf.ningfrpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午8:23
 */
public class LocalRegistry {
    private static final Map<String,Class<?>> map =new ConcurrentHashMap<>();

    //注册服务
    public static void register(String serviceName,Class<?> implClass) {
        map.put(serviceName,implClass);
    }

    //获取服务
    public static Class<?> get(String serviceName) {
        return map.get(serviceName);
    }

    //删除服务
    public static void remove(String serviceName) {
        map.remove(serviceName);
    }
}
