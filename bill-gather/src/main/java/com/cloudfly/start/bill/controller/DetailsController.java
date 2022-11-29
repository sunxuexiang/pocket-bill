package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.service.BillBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/detailsController")
@RestController
public class DetailsController {

    @Autowired
    private BillBookService billBookService;

    @RequestMapping("/getDetails")
    public String getDetails(){
        String s = billBookService.queryById(1);
        System.out.println(s);
        return "账单详情";
    }
}
