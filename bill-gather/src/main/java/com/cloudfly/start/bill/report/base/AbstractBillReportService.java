package com.cloudfly.start.bill.report.base;



import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookReportGatherMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class AbstractBillReportService implements BaseBillReportService {

    @Autowired
    private BillBookReportGatherMapper billReportMapper;

    private Integer infoPayType;

    private int year;

    private int month;

    public Integer getInfoPayType() {
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

    public void setReportBaseData(Integer infoPayType,int year,int month) {
        this.infoPayType=infoPayType;
        this.year=year;
        this.month=month;
    }

    public List<BillBookInfo> generateReport(Integer bookId,Integer infoPayType,int year,int month){
        this.setReportBaseData(infoPayType,year,month);
        Date startTime=countQueryStartTime();
        Date endTime=countQueryEndTime();
        return billReportMapper.generateReport(bookId,startTime,endTime,infoPayType);
    }
    /**
     * @Description: 计算报表查询开始时间
     * @author lightning
     * @date 2022/12/24 11:44
     * @return Date
     */
    public abstract Date countQueryStartTime();

    /**
     * @Description: 计算报表查询结束时间
     * @author lightning
     * @date 2022/12/24 11:44
     * @return Date
     */
    public abstract Date countQueryEndTime();

}
