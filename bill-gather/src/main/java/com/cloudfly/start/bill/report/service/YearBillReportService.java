package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class YearBillReportService extends AbstractBillReportService {
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
