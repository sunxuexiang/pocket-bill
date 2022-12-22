package com.cloudfly.start.bill.report.base;



import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookReportGatherMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class BaseBillReportServiceAbs implements BaseBillReportService {

    @Autowired
    private BillBookReportGatherMapper billReportMapper;

    private String infoPayType;

    private int year;

    private int month;

    public String getInfoPayType() {
        return infoPayType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setReportBaseData(String reportType,int year,int month) {
        this.infoPayType=infoPayType;
        this.year=year;
        this.month=month;
    }

    public List<BillBookInfo> generateReport(String infoPayType,int year,int month){
        this.setReportBaseData(infoPayType,year,month);
        Date startTime=countQueryStartTime();
        Date endTime=countQueryEndTime();
        return billReportMapper.generateReport(startTime,endTime,infoPayType);
    }
    /**
     * 计算当前报表查询开始时间
     * */
    public abstract Date countQueryStartTime();
    /**
     * 计算当前报表查询结束时间
     * */
    public abstract Date countQueryEndTime();

}
