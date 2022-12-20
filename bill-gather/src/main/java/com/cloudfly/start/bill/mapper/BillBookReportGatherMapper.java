package com.cloudfly.start.bill.mapper;

import com.cloudfly.start.bill.entity.BillBookInfo;

import java.util.Date;
import java.util.List;

public interface BillBookReportGatherMapper {

    List<BillBookInfo> generateReport(Date startTime, Date endTime, String infoPayType);
}
