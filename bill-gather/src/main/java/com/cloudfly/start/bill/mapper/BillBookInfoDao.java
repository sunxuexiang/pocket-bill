package com.cloudfly.start.bill.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface BillBookInfoDao extends BaseMapper<BillBookInfo> {
}
