package com.threeclear.pollution.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.threeclear.pollution.dao.CyyyDevInfoDao;
import com.threeclear.pollution.dto.CookingFumeDto;
import com.threeclear.pollution.entity.CyyyDevInfo;
import com.threeclear.pollution.service.CookingFumeService;
import com.threeclear.pollution.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 餐饮油烟(CookingFumeServiceImpl)表服务实现类
 *
 * @author lichen
 * @since 20220108
 */
@Service("CookingFumeService")
@Slf4j
public class CookingFumeServiceImpl implements CookingFumeService {
    @Resource
    private CyyyDevInfoDao cyyyDevInfoDao;

    final static String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    final static String ALARM_FLAG = "已解除，已完结";

    @Override
    public PageInfo<CookingFumeDataVo> queryAlarmInfoList(CookingFumeDto cookingFumeDto) {
        Date start = null;
        Date end = null;
        if(cookingFumeDto.getStartTime() != null && !"".equals(cookingFumeDto.getStartTime())){
            String startTime = cookingFumeDto.getStartTime();
            String endTime = cookingFumeDto.getEndTime();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STR);
            try {
                start = sdf.parse(startTime);
                end = sdf.parse(endTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String corpname = cookingFumeDto.getCorpname();
        String region = cookingFumeDto.getCountyCode();
        int size = cookingFumeDto.getSize();
        int num = cookingFumeDto.getCurrent();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("startTime",start);
        param.put("endTime",end);
        param.put("corpname",corpname);
        param.put("region",region);
        param.put("pageSize",size);
        param.put("pageNum",(num-1)*size);
        param.put("statuses",cookingFumeDto.getStatuses());
        List<CookingFumeDataVo> cookingFumeDataVos = cyyyDevInfoDao.selectDataByTime(param);
        int total = cyyyDevInfoDao.selectTotalByData(param);
        //增加状态、处置人、处理结果、报警解除时间等字段信息
        for(CookingFumeDataVo cookingFumeDataVo:cookingFumeDataVos){
            if(cookingFumeDataVo.getV0x1().compareTo(new BigDecimal(1))==0){
                cookingFumeDataVo.setFanSwitch("开");
            }else {
                cookingFumeDataVo.setFanSwitch("关");
            }
            if(cookingFumeDataVo.getV0x2().compareTo(new BigDecimal(1))==0){
                cookingFumeDataVo.setPuSwitch("开");
            }else {
                cookingFumeDataVo.setPuSwitch("关");
            }
        }
        //分页返回
        PageInfo<CookingFumeDataVo> pageInfo = new PageInfo<CookingFumeDataVo>();
        pageInfo.setTotal(total);
        pageInfo.setList(cookingFumeDataVos);
        log.info("餐饮油烟列表查询 -->  end");
        return pageInfo;
    }

}

