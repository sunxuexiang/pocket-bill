package com.cloudfly.start.bill.report.base;



import com.cloudfly.start.bill.mapper.BillBookReportGatherMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public abstract class BaseBillReportServiceAbs implements BaseBillReportService {

    @Autowired
    private BillBookReportGatherMapper billReportMapper;

    private String infoPayType;

    public String getInfoPayType() {
        return infoPayType;
    }

    public void setReportBaseData(String reportType) {
        this.infoPayType=infoPayType;
    }

    public void generateReport(String infoPayType){
        this.setReportBaseData(infoPayType);
        Date startTime=countQueryStartDate();
        Date endTime=countQueryEndDate();
        billReportMapper.generateReport(startTime,endTime,infoPayType);
    }
    /**
     * 计算当前报表查询开始时间
     * */
    public abstract Date countQueryStartDate();
    /**
     * 计算当前报表查询结束时间
     * */
    public abstract Date countQueryEndDate();

}
