package com.cloudfly.start.bill.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cloudfly.start.bill.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate",new Date(),metaObject);
        this.setFieldValByName("createBy", JwtUtils.getCurrentLoginUser(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDate",new Date(),metaObject);
        this.setFieldValByName("updateBy",JwtUtils.getCurrentLoginUser(),metaObject);
    }

}
