package com.cloudfly.start.bill.controller;


import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import com.cloudfly.start.bill.utils.DateUtil;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/billBookAnnualSummaryController")
@RestController
public class BillBookAnnualSummaryController {

    private static Logger logger= LoggerFactory.getLogger(BillBookAnnualSummaryController.class);

    @Autowired
    BillBookAnnualSummaryService billBookAnnualSummaryService;

    /**
     * @Description 计算年度账单，汇总一年的数据显示
     * @author : ligntning
     * */
    @RequestMapping("/queryAnnualSummaryReportList")
    public R queryAnnualSummaryReportList(@RequestParam("bookId") int bookId,@RequestParam("year") int year){
        logger.info("queryAnnualSummaryReportList start with bookId={},year={}",bookId,year);
        try {

            return R.ok().put(CommonContant.RESPONSE_FIELD,billBookAnnualSummaryService.queryAnnualSummaryReportList(bookId,year));
        }catch (Exception e){
            logger.error("queryAnnualSummaryReportList occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }
}