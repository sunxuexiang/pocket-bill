package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.remoteapi.GatherFeignService;
import com.cloudfly.start.bill.service.BillBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/detailsController")
@RestController
public class DetailsController {



    @Autowired
    private GatherFeignService gatherFeignService;

    @Autowired
    private BillBookInfoService bookInfoService;

    @RequestMapping("/getDetails")
    public String getDetails(){
        System.out.println(gatherFeignService.getGather());
        return "账单详情";
    }
}
