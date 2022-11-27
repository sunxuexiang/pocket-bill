package com.cloudfly.start.bill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/detailsController")
@RestController
public class DetailsController {

    @RequestMapping("/getDetails")
    public String getDetails(){
        return "账单详情";
    }
}
