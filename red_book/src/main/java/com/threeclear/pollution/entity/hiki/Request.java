package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * @author guojing
 * @date 2022/1/11 11:26
 */
@Data
public class Request<T> {
    private T data;
}
