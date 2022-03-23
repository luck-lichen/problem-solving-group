package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * 大华二次鉴权返回的结果
 *
 * @author guojing
 * @date 2022/1/11 09:19
 */
@Data
public class AuthorizeTwoPojo {
    /**
     * 保活间隔（秒）
     */
    private Integer duration;

    /**
     * 令牌
     */
    private String token;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户等级
     * 1=超级管理员，2=管理员，3=自定义角色
     */
    private String userLevel;

    /**
     * 平台能力集
     */
    private String serviceAbilty;

    /**
     * 版本信息
     */
    private VersionInfo versionInfo;

    /**
     * 电子地图路径
     */
    private String emapUrl;

    /**
     * 呼叫号码
     */
    private String sipNum;

    /**
     * 会话凭证更新频率（秒）
     */
    private Integer tokenRate;

    /**
     * 秘钥密文=加密(秘钥, 终端公钥)
     */
    private String secretKey;

    /**
     * 向量密文=加密(向量, 终端公钥)
     */
    private String secretVector;

    /**
     * 是否支持复用：0-否，1-是
     */
    private String reused;

    @Data
    public static class VersionInfo {
        /**
         * 客户端最新版本
         */
        private String lastVersion;

        /**
         * 客户端更新路径
         */
        private String updateUrl;
    }
}
