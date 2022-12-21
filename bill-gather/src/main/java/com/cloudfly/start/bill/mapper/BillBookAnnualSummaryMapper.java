package com.cloudfly.start.bill.mapper;


import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface BillBookAnnualSummaryMapper {

    List<Map<String,Integer>> queryAnnualSummaryReportList(@Param("bookId") String bookId,
                              @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
