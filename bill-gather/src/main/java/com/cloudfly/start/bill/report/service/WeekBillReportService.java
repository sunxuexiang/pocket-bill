package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        BigDecimal average=total.divide(new BigDecimal(7),2, RoundingMode.HALF_UP);
        resultMap.put("average",average);
        List<Map<String,Object>> resultList= (List<Map<String, Object>>) resultMap.get(CommonContant.RESPONSE_FIELD);
        int preDay=Integer.parseInt(DateUtil.getCurrentDay(countQueryStartTime()));
        int nextDay=Integer.parseInt(DateUtil.getCurrentDay(countQueryEndTime()));

        for(Map<String,Object> map:resultList){
            int date=Integer.parseInt((String)map.get("date"));
            if(date<=preDay||date>=nextDay){
                resultList.remove(map);
            }
        }
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
