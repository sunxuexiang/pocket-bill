package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * @param reportList
     * @return
     */
    @Override
    public List<Map<String,Object>> generateReport(List<BillBookInfo> reportList) {
        return null;
    }

}
