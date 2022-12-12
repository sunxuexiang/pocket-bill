package com.cloudfly.start.bill.mapper;

import com.cloudfly.start.bill.entity.BillBookInfo;

import java.util.Date;

public interface BillBookReportGatherMapper {

    BillBookInfo generateReport(Date startTime, Date endTime,String infoPayType);
}
