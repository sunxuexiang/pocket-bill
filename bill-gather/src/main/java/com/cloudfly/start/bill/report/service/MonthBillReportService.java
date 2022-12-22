package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.BaseBillReportServiceAbs;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MonthBillReportService extends BaseBillReportServiceAbs {
    /**
     * @return
     */
    @Override
    public Date countQueryStartTime() {
        return DateUtil.getMonthFirstDay(this.getYear(),this.getMonth());
    }

    /**
     * @return
     */
    @Override
    public Date countQueryEndTime() {
        return DateUtil.getMonthLastDay(this.getYear(),this.getMonth());
    }
}
