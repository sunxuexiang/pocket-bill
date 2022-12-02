package com.cloudfly.start.bill.report.base;



public abstract class BaseBillReportServiceAbs implements BaseBillReportService {

    @Override
    public void setReportBaseData() {

    }

    public abstract void generateReport();
}
