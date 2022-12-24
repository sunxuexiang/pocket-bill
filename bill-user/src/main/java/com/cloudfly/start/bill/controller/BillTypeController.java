package com.cloudfly.start.bill.controller;


import com.cloudfly.start.bill.entity.BillType;
import com.cloudfly.start.bill.service.BillTypeService;
import com.cloudfly.start.bill.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/bill-type")
public class BillTypeController {

    @Autowired
    private BillTypeService typeService;

    @RequestMapping("addBillType")
    public R addBillType (@RequestBody BillType billType) {
        return typeService.addType(billType);
    }

    @RequestMapping("queryBillType")
    public R queryBillType(@Param("type") int type){
        return typeService.queryType(type);
    }


}
