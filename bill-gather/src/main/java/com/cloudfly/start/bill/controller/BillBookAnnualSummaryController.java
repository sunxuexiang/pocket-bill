package com.cloudfly.start.bill.controller;


import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/billBookAnnualSummaryController")
@RestController
public class BillBookAnnualSummaryController {

    @Autowired
    BillBookAnnualSummaryService billBookAnnualSummaryService;

    @RequestMapping("/queryAnnualSummaryList")
    public R queryAnnualSummaryList(@RequestParam("bookId") String bookId){
        try {
            return R.ok().put("ResponseData",billBookAnnualSummaryService.queryAnnualSummaryList(bookId));
        }catch (Exception e){
            return R.error().put("ResponseData", ExceptionUtils.getStackTrace(e));
        }
    }
}
