package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public List<Map<String,Object>> generateReport(List<BillBookInfo> reportList) {

        return null;
    }

}
