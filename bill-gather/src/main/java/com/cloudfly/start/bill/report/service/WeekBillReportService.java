package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeekBillReportService extends AbstractBillReportService {
    /**
     * @return
     */
    @Override
    public Date countQueryStartTime() {
        return DateUtil.getWeekFirstDay();
    }

    /**
     * @return
     */
    @Override
    public Date countQueryEndTime() {
        return DateUtil.getWeekLastDay();
    }

}
