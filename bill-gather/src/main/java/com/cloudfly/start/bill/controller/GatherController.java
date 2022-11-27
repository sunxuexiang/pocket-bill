package com.cloudfly.start.bill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gatherController")
@RestController
public class GatherController {

    @RequestMapping("/getGather")
    public String getDetails(){
        return "2022年11月30号 和雪蛤去阿飘坟头蹦迪";
    }
}
