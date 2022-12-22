package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.BaseBillReportServiceAbs;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Service
public class YearBillReportService extends BaseBillReportServiceAbs {
    /**
     * @return Date
     */
    @Override
    public Date countQueryStartTime() {
        return DateUtil.getYearFirstDay(this.getYear());
    }

    /**
     * @return Date
     */
    @Override
    public Date countQueryEndTime() {
        return DateUtil.getYearLastDay(this.getYear());
    }

}
