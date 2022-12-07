package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.service.BillShareService;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill-share")
public class BillShareController {

    @Autowired
    private BillShareService billShareService;

    /**
    * @Description : 账单共享页面
    * @author: Hulk
    * @date : 2022/12/4 19:58
    */
   @RequestMapping("/queryByBillAndUserId")
   public R queryByBillAndUserId(Integer billId){
        return billShareService.queryByBillAndUserId(billId);
   }

   /**
   * @Description : 账单共享页面添加其他共享人
   * @author: Hulk
   * @date : 2022/12/4 19:59
   */
   @RequestMapping("/addShare")
    public R addShare(BillShare billShare) {
        return billShareService.addShare(billShare);
    }

    /**
    * @Description : 修改共享账单人权限
    * @author: Hulk
    * @date : 2022/12/4 20:00
    */
    @RequestMapping("/updateShareByBill")
    public R updateShareByBill(BillShare list) {
        return billShareService.updateShareByBill(list);
    }

}
