package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.dao.BillDao;
import com.cloudfly.start.bill.entity.BillBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillBookMapper extends BaseMapper<BillBook>{

    List<BillDao> queryBillByUserId(@Param("userId") Integer userId);
}