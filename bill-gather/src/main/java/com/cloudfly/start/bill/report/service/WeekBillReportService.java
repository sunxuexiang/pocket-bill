package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.BaseBillReportServiceAbs;
import com.cloudfly.start.bill.utils.DateUtil;

import java.util.Date;

public class WeekBillReportService extends BaseBillReportServiceAbs {
    /**
     * @return
     */
    @Override
    public Date countQueryStartDate() {
        return DateUtil.getWeekFirstDay();
    }

    /**
     * @return
     */
    @Override
    public Date countQueryEndDate() {
        return DateUtil.getWeekLastDay();
    }

}
