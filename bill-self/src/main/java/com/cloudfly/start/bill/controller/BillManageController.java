package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.service.BillManageService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill-manage")
public class BillManageController {

    @Autowired
    private BillManageService billManageService;

    /**
    * @Description : 添加账单
    * @author: Hulk
    * @date : 2022/12/4 20:00
    */
    @RequestMapping("/addBill")
    public R addBill(@RequestBody BillBook billBook) {

        return billManageService.addBillManage(billBook);
    }

    /**
    * @Description : 修改账单
    * @author: Hulk
    * @date : 2022/12/4 20:00
    */
    @RequestMapping("/updateBillManage")
    public R updateBillManage(@RequestBody BillBook billBook) {
        return billManageService.updateBillManage(billBook);
    }

    /**
    * @Description : 查询单个账单
    * @author: Hulk
    * @date : 2022/12/4 20:00
    */
    @RequestMapping("/queryByBillId")
    public R queryByBillId(@RequestParam("billId") Integer billId) {
        return billManageService.queryByBillId(billId);
    }
    
    /**
    * @Description : 查询当前用户所有相关账单
    * @author: Hulk
    * @date : 2022/12/4 20:15
    */
    @RequestMapping("/queryBillByUserId")
    public R queryBillByUserId(){
        return billManageService.queryByUserIdList();
    }
}
