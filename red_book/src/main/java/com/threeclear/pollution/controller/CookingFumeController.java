package com.threeclear.pollution.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.threeclear.baseweb.util.ExcelUtil;
import com.threeclear.baseweb.vo.ServerResponse;
import com.threeclear.pollution.dto.CookingFumeDto;
import com.threeclear.pollution.entity.CyyyDevInfo;
import com.threeclear.pollution.model.CookingFumeDataModel;
import com.threeclear.pollution.model.CookingMonitoringModel;
import com.threeclear.pollution.service.CookingFumeService;
import com.threeclear.pollution.vo.CookingFumeDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 餐饮油烟控制层
 *
 * @author lichen
 * @since 20220107
 */
@RestController
@Slf4j
@RequestMapping("cooking/fume")
public class CookingFumeController {

    @Resource
    private CookingFumeService cookingFumeService;

    /**
     * 报警信息 - 根据时间、行政区划和餐饮名称,查询餐饮油烟列表
     * 入参为：startTime、endTime、region、corpname、pageSize、pageNum
     * @param cookingFumeDto
     * @return
     */
    @PostMapping("queryAlarmInfo")
    public ServerResponse<PageInfo<CookingFumeDataVo>> queryAlarmInfo(@RequestBody CookingFumeDto cookingFumeDto){
        log.info("餐饮油烟报警列表查询 -->  start");
        return ServerResponse.createBySuccess(cookingFumeService.queryAlarmInfoList(cookingFumeDto));
    }
}

