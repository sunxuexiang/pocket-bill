package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BillBookInfoMapper extends BaseMapper<BillBookInfo> {

    List<BillBookInfo> queryBillDetailsCustomize(BillBookInfo billBookInfo);
}
