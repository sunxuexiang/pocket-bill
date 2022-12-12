package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.BaseBillReportServiceAbs;
import com.cloudfly.start.bill.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class YearBillReportService extends BaseBillReportServiceAbs {
    /**
     * @return Date
     */
    @Override
    public Date countQueryStartDate() {
        return DateUtil.getCurrYearFirst();
    }

    /**
     * @return Date
     */
    @Override
    public Date countQueryEndDate() {
        return DateUtil.getCurrYearLast();
    }

}
