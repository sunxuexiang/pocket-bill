package com.cloudfly.start.bill.controller;


import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/billBookAnnualSummaryController")
@RestController
public class BillBookAnnualSummaryController {

    private static Logger logger= LoggerFactory.getLogger(BillBookAnnualSummaryController.class);

    @Autowired
    BillBookAnnualSummaryService billBookAnnualSummaryService;

    @RequestMapping("/queryAnnualSummaryReportList")
    public R queryAnnualSummaryReportList(@RequestParam("bookId") String bookId){
        logger.info("queryAnnualSummaryReportList start with bookId={}",bookId);
        try {
            return R.ok().put("result",billBookAnnualSummaryService.queryAnnualSummaryReportList(bookId));
        }catch (Exception e){
            logger.error("queryAnnualSummaryReportList occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }
}