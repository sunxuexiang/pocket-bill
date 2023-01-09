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
    public Map<String,Object> generateReportBySelf(List<BillBookInfo> reportList) {
        Map<String,Object> resultMap=billDataClassifyByDate(reportList,new int[32]);
        BigDecimal total=(BigDecimal) resultMap.get("total");
        BigDecimal average=total.divide(new BigDecimal(7));
        resultMap.put("average",average);
        return resultMap;
    }

    /**
     * @param date
     * @return
     */
    @Override
    public String getMonthOrDayOrWeek(Date date) {
        return DateUtil.getCurrentDay(date);
    }

}
