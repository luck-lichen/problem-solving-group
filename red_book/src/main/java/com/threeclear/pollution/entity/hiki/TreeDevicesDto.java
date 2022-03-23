package com.threeclear.pollution.entity.hiki;

import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * 获取设备树
 *
 * @author guojing
 * @date 2022/1/11 10:37
 */
@Data
public class TreeDevicesDto {
    /**
     * 组织节点OrgCode，暂未使用
     */
    private String orgCode;

    /**
     * 设备编码, 如果为空, 则表示获取所有设备
     */
    private List<String> deviceCodes = Lists.emptyList();

    /**
     * 设备大类:
     * 1-编码器,5-卡口,8-门禁等；比如参数[1]
     */
    private List<Integer> categories = Lists.emptyList();
}
