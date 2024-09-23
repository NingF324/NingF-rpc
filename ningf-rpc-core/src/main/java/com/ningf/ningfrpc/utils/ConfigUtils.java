package com.ningf.ningfrpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import java.util.Stack;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/23 上午9:06
 */
public class ConfigUtils {
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass,prefix,"");
    }

    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());
        return props.toBean(tClass,prefix);
    }
}
