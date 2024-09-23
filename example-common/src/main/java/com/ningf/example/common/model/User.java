package com.ningf.example.common.model;

import java.io.Serializable;

/**
 * @description:
 * @author: Lenovo
 * @time: 2024/9/18 下午7:28
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
