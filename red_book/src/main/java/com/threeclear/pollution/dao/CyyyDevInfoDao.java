package com.threeclear.pollution.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.threeclear.pollution.entity.CyyyDevInfo;
import com.threeclear.pollution.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CyyyDevInfoDao {

	//根据时间、区县和企业名称查询报警信息
	List<CookingFumeDataVo> selectDataByTime(Map<String,Object> param);

	//报警信息总条数
	int selectTotalByData(Map<String,Object> param);

}
