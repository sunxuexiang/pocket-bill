package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.report.service.MonthBillReportService;
import com.cloudfly.start.bill.report.service.WeekBillReportService;
import com.cloudfly.start.bill.report.service.YearBillReportService;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloudfly.start.bill.contants.ReportContant;

@RestController
@RequestMapping("/billBookReportGatherController")
public class BillBookReportGatherController {

    @Autowired
    private YearBillReportService yearBillReportService;

    @Autowired
    private MonthBillReportService monthBillReportService;

    @Autowired
    private WeekBillReportService weekBillReportService;

    @RequestMapping("/queryReporyByYear")
    public R queryReporyByYear(@RequestParam("bookId") Integer bookId,@RequestParam("infoPayType") String infoPayType){
        try {
            yearBillReportService.generateReport(infoPayType);

        }catch(Exception e){

        }
        return null;
    }

    @RequestMapping("/queryReporyByMonth")
    public R queryReporyByMonth(@RequestParam("bookId") Integer bookId,@RequestParam("infoPayType") String infoPayType){
        try {
            monthBillReportService.generateReport(infoPayType);

        }catch(Exception e){

        }
        return null;
    }

    @RequestMapping("/queryReporyByWeek")
    public R queryReporyByWeek(@RequestParam("bookId") Integer bookId,@RequestParam("infoPayType") String infoPayType){
        try {
            weekBillReportService.generateReport(infoPayType);

        }catch(Exception e){

        }
        return null;
    }
}
