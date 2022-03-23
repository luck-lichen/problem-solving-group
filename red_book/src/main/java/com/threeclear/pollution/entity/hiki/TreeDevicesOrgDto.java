package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * 组织设备树全部
 * 设备编码和组织编码都有
 * @author guojing
 * @date 2022/1/11 11:00
 */
@Data
public class TreeDevicesOrgDto {
    /**
     * 通道类型：
     * 1-编码器通道，2-解码器通道，3-报警输入通道，4-报警
     * 输出通道，5-大屏输入，6-大屏输出，7-门禁控制，8-语音控制，9-
     * 转码，10-动环，11-POS；为空时表示不显示通道；
     */
    private String channelTypes;

    /**
     * 无效参数，为空即可
     */
    private String sort;

    /**
     * 组织编码
     * 为空时则表示根节点001
     */
    private String orgCode;

    /**
     * 登录时获取的token，也可以直接带在URL后面
     */
    private String token;
}
