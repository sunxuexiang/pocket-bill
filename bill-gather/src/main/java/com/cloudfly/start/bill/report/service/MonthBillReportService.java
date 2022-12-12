package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.BaseBillReportServiceAbs;
import com.cloudfly.start.bill.utils.DateUtil;

import java.util.Date;

public class MonthBillReportService extends BaseBillReportServiceAbs {
    /**
     * @return
     */
    @Override
    public Date countQueryStartDate() {
        return DateUtil.getMonthFirstDay();
    }

    /**
     * @return
     */
    @Override
    public Date countQueryEndDate() {
        return DateUtil.getMonthLastDay();
    }
}
