package com.cloudfly.start.bill.mapper;

import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BillBookReportGatherMapper {

    List<BillBookInfo> generateReport(@Param("bookId")Integer bookId, @Param("startTime")Date startTime,
                                      @Param("endTime")Date endTime, @Param("infoPayType")Integer infoPayType);
}
