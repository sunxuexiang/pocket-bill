package com.cloudfly.start.bill.mapper;


import com.cloudfly.start.bill.entity.BillBookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface BillBookAnnualSummaryMapper {

    BillBookInfo queryAnnualSummaryList(@Param("bookId") String bookId);
}
