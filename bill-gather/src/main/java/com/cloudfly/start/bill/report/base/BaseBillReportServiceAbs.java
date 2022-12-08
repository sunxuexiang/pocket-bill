package com.cloudfly.start.bill.report.base;



import com.cloudfly.start.bill.mapper.BillBookReportGatherMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseBillReportServiceAbs implements BaseBillReportService {

    @Autowired
    private BillBookReportGatherMapper billReportMapper;

    private String reportType;

    public String getReportType(){
        return this.reportType;
    }
    @Override
    public void setReportBaseData(String reportType) {
        this.reportType=reportType;
    }

    public void generateReport(String reportType){
        this.setReportBaseData(reportType);
        String startTime=countQueryStartDate();
        String endTime=countQueryEndDate();
        billReportMapper.generateReport(startTime,endTime);
    }

    public abstract String countQueryStartDate();
    public abstract String countQueryEndDate();

}
