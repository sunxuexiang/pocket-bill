package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.exception.BillBusinessException;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.report.service.MonthBillReportService;
import com.cloudfly.start.bill.report.service.WeekBillReportService;
import com.cloudfly.start.bill.report.service.YearBillReportService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/billBookReportGatherController")
public class BillBookReportGatherController {

    private static Logger logger= LoggerFactory.getLogger(BillBookReportGatherController.class);

    @Autowired
    private YearBillReportService yearBillReportService;

    @Autowired
    private MonthBillReportService monthBillReportService;

    @Autowired
    private WeekBillReportService weekBillReportService;

    @RequestMapping("/queryReporyByYear")
    public R queryReporyByYear(@RequestParam("bookId") Integer bookId, @RequestParam("infoPayType") String infoPayType,
                               @RequestParam("year") int year){
        logger.info(" queryReporyByYear start with bookId:[{}],infoPayType:[{}],year:[{}]",bookId,infoPayType,year);

        try {
            return R.ok().put(CommonContant.RESPONSE_FIELD,yearBillReportService.generateReport(infoPayType,year,0));
        }catch(Exception e){
            logger.error("queryReporyByYear occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }

    @RequestMapping("/queryReporyByMonth")
    public R queryReporyByMonth(@RequestParam("bookId") Integer bookId, @RequestParam("infoPayType") String infoPayType,
                                @RequestParam("year") int year, @RequestParam("month") int month){
        logger.info(" queryReporyByMonth start with bookId={},infoPayType={}",bookId,infoPayType);
        try {
            return R.ok().put(CommonContant.RESPONSE_FIELD,monthBillReportService.generateReport(infoPayType,year,month));
        }catch(Exception e){
            logger.error("queryReporyByMonth occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }

    @RequestMapping("/queryReporyByWeek")
    public R queryReporyByWeek(@RequestParam("bookId") Integer bookId,
                               @RequestParam("infoPayType") String infoPayType){
        logger.info(" queryReporyByWeek start with bookId={},infoPayType={}",bookId,infoPayType);
        try {
            return R.ok().put(CommonContant.RESPONSE_FIELD,weekBillReportService.generateReport(infoPayType,0,0));
        }catch(Exception e){
            logger.error("queryReporyByWeek occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }
}
