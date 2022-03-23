package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * @author guojing
 * @date 2022/1/11 10:48
 */
@Data
public class Response<T> {
    /**
     * 错误代码
     * 1000为正确
     */
    private int code;

    /**
     * 返回描述
     */
    private String desc;

    /**
     * 返回的数据
     */
    private T data;
}
