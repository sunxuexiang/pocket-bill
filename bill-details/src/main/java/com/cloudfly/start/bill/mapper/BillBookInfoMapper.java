package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BillBookInfoMapper extends BaseMapper<BillBookInfo> {

    List<BillBookInfo> queryBillDetailsCustomize(@Param("bookId")Integer bookId, @Param("infoRemark")String infoRemark,
                                                 @Param("startTime") Date startTime, @Param("endTime")Date endTime,
                                                 @Param("startMoney") BigDecimal startMoney, @Param("endMoney")BigDecimal endMoney,
                                                 @Param("userName")String userName);
}
