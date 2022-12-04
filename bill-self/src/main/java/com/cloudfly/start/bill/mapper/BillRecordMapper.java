package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.dao.BillAndUserDao;
import com.cloudfly.start.bill.entity.BillRecord;
import com.cloudfly.start.bill.entity.BillShare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BillRecordMapper extends BaseMapper<BillRecord>{


}
