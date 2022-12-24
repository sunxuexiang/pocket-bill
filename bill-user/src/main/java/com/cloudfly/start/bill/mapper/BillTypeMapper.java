package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.entity.BillType;
import com.cloudfly.start.bill.entity.BillUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BillTypeMapper extends BaseMapper<BillType>{
}
