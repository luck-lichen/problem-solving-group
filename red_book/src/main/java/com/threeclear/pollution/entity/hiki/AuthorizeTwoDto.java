package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * @author guojing
 * @date 2022/1/11 09:16
 */
@Data
public class AuthorizeTwoDto {
    /**
     * mac 地址，可以传空
     */
    private String mac;

    /**
     *  签名，根据一次登录信息生成的签名
     */
    private String signature;

    /**
     *  用户名
     */
    private String userName;

    /**
     * 随机值
     * 第一次验证返回的随机值
     */
    private String randomKey;


    /**
     * 终端RSA公钥
     * 如果是MD5加密可以不传
     */
    private String publicKey;

    /**
     * 加密类型
     * MD5
     */
    private String encryptType;


    /**
     * IP地址
     * 可以传""
     */
    private String ipAddress;

    /**
     * 用户类型
     * 固定"WINPC_V1"
     */
    private String clientType = "WINPC_V1";

    /**
     * 0 - 系统用户
     * 1 - 域用户
     */
    private String userType;
}
