package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.entity.BillType;
import com.cloudfly.start.bill.entity.BillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillTypeMapper extends BaseMapper<BillType>{

    List<BillType> queryList(@Param("userId") int userId,@Param("type") int typeId);
}
