package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.service.BillRecordService;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 用户打卡记录
 * @author: Hulk
 * @date : 0420:18
 */
@RestController
@RequestMapping("/bill-record")
public class BillRecordController {

    @Autowired
    private BillRecordService recordService;

    /**
    * @Description : 添加当天用户打卡记录
    * @author: Hulk
    * @date : 2022/12/4 20:42
    */
    @RequestMapping("/addRecord")
    public R addRecord() {
        return recordService.addRecord();
    }

    /**
    * @Description : 查询用户打卡记录
    * @author: Hulk
    * @date : 2022/12/4 20:43
    */
    @RequestMapping("/queryRecordByUserId")
    public R queryRecordByUserId () {
        return recordService.querRecordByUserId();
    }

}
