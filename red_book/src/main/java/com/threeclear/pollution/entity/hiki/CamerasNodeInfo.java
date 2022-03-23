package com.threeclear.pollution.entity.hiki;

import lombok.Data;

/**
 * @author guojing
 * @date 2022/1/8 18:10
 */
@Data
public class CamerasNodeInfo {
    private String indexCode;
    private String nodeType;
    private String name;
    private String regionPath;
    private String parentIndexCode;
    private Integer cascadeType;
    private String externalIndexCode;
    private Integer sort;
    private String createTime;
    private String updateTime;
    private String regionCode;
    private Boolean available;
    private Boolean leaf;
    private Integer catalogType;
    private String cascadeCode;
}
