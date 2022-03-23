package com.threeclear.pollution.util;

import com.google.common.collect.Sets;
import com.threeclear.pollution.entity.hiki.CamerasInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * 视频监控列表
 * @author guojing
 * @date 2022/1/21 14:16
 */
@Data
public class CameraOrgListVo {

    @ApiModelProperty("区域代码")
    private String orgCode;

    @ApiModelProperty("区域名称")
    private String orgName;

    @ApiModelProperty("上级组织code")
    private String parentCode;

    @ApiModelProperty("下级区域列表")
    private Set<CameraOrgListVo> orgList = Sets.newHashSet();

    @ApiModelProperty("本级视频列表")
    private Set<CamerasInfo> camerasList = Sets.newHashSet();

}
