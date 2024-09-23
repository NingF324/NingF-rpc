package com.ningf.ningfrpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/19 上午11:30
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
