package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonthBillReportService extends AbstractBillReportService {
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

    /**
     * @Description: 统计月度报表
     * @author lightning
     * @date 2023/1/8 19:03
     * @return Object
     */
    @Override
    public Map<String,Object> generateReportBySelf(List<BillBookInfo> reportList) {
        Map<String,Object> resultMap=billDataClassifyByDate(reportList,new int[32]);
        BigDecimal total=(BigDecimal) resultMap.get("total");
        Integer subtractDay=DateUtil.getSubtractDay(countQueryEndTime(),countQueryStartTime());
        BigDecimal average=total.divide(new BigDecimal(subtractDay)).setScale(2, RoundingMode.HALF_UP);
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
