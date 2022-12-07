package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.dao.BillAndUserDao;
import com.cloudfly.start.bill.dao.BillDao;
import com.cloudfly.start.bill.entity.BillShare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillShareMapper extends BaseMapper<BillShare>{

    BillAndUserDao queryByBillAndUserId(@Param("billBookId") Integer billBookId);

}
