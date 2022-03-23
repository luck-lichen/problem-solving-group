package com.threeclear.pollution.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.Data;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 通用默认字段处理器
 * @author 邵海楠
 * @date 2021/3/5 18:31
 * @description
 */
@Data
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "gmtCreate", new Date());
        this.fillStrategy(metaObject, "gmtModified", new Date());
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "gmtModified", new Date());
    }
}
