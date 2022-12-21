package com.cloudfly.start.bill.service;

import com.cloudfly.start.bill.entity.BillBookInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillBookAnnualSummaryService {

    Map<String,Object> queryAnnualSummaryReportList(int bookId,int year);

}
