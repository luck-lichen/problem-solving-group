package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * 大华一次鉴权返回的结果
 * @author guojing
 * @date 2022/1/11 09:19
 */
@Data
public class AuthorizeOnePojo {
    /**
     * 加密域
     */
    private String realm;

    /**
     * 随机密钥
     */
    private String randomKey;

    /**
     * 加密方式
     * MD5 RSA
     * 通常是MD5
     */
    private String encryptType;

    /**
     * 平台RSA加密公钥，并以Base64编码
     * MD5方式下可以不用考虑
     */
    private String publickey;
}
