package com.threeclear.pollution.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.threeclear.pollution.dto.CookingFumeDto;
import com.threeclear.pollution.entity.CyyyDevInfo;
import com.threeclear.pollution.vo.CookingFumeDataVo;

import java.util.List;

/**
 * 餐饮油烟(CookingFumeService)服务接口
 *
 * @author lichen
 * @since 20220108
 */
public interface CookingFumeService {

    PageInfo<CookingFumeDataVo> queryAlarmInfoList(CookingFumeDto cookingFumeDto);

}

