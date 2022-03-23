package com.threeclear.pollution.entity.hiki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guojing
 * @date 2022/1/11 09:16
 */
@Data
public class AuthorizeOneDto {
    /**
     * 用户名
     */
    private String userName;

    /**
     * ip地址 可以为空
     */
    private String ipAddress = "";

    /**
     * 客户端类型固定为"WINPC_V1"
     */
    private String clientType = "WINPC_V1";
}
