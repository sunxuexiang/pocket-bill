package com.cloudfly.start.bill.service;

import com.cloudfly.start.bill.entity.BillBookInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillBookAnnualSummaryService {

    List<Map<String,String>> queryAnnualSummaryReportList(String bookId, Date startTime, Date endTime);

}
