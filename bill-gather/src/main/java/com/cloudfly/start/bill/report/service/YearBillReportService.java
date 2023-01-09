package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


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

    /**
     * @Description: 统计年度报表
     * @author lightning
     * @date 2023/1/8 19:03
     * @return Object
     */
    @Override
    public Map<String,Object> generateReportBySelf(List<BillBookInfo> reportList) {
        Map<String,Object> resultMap=billDataClassifyByDate(reportList,new int[13]);
        BigDecimal total=(BigDecimal) resultMap.get("total");
        BigDecimal average=total.divide(new BigDecimal(12),2, RoundingMode.HALF_UP);
        resultMap.put("average",average);
        return resultMap;
    }

    /**
     * @return
     */
    @Override
    public String getMonthOrDayOrWeek(Date date) {
        return DateUtil.getCurrentMonth(date);
    }
}
