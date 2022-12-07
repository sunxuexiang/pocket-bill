package com.cloudfly.start.bill.report.base;



public abstract class BaseBillReportServiceAbs implements BaseBillReportService {

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
    }

    public abstract String countQueryStartDate();
    public abstract String countQueryEndDate();

}
