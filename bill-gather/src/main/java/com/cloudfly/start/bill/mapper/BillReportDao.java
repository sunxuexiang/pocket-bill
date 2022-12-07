package com.cloudfly.start.bill.dao;

public interface BillReportDao {

    String generateReport(String startTime,String endTime);
}
