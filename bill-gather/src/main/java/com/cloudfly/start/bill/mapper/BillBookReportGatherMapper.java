package com.cloudfly.start.bill.mapper;

import com.cloudfly.start.bill.entity.BillBookInfo;

public interface BillBookReportGatherMapper {

    BillBookInfo generateReport(String startTime, String endTime);
}
