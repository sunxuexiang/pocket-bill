package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.Bill;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillManageService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bill-manage")
public class BillManageController {

    private Logger logger= LoggerFactory.getLogger(BillManageController.class);

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
     * @Description: 查询用户默认账本
     * @author lightning
     * @date 2022/12/24 16:12
     * @return R
     */
    @RequestMapping("/queryDefaultBillByUserId")
    public R queryDefaultBillByUserId() {
        logger.info("queryDefaultBillByUserId start ");

        return R.ok().put(CommonContant.RESPONSE_FIELD,billManageService.queryDefaultBillByUserId());

    }


    /**
     * @Description : 查询当前用户所有相关账单
     * @author: Hulk
     * @date : 2022/12/4 20:15
     */
    @RequestMapping("/queryBillByUserId")
    public R queryBillByUserId(){
        logger.info("queryBillByUserId start ");

        return R.ok().put(CommonContant.RESPONSE_FIELD,billManageService.queryBillByUserId());

    }

    /**
     * @Description : 修改用户默认账单
     * @author: Hulk
     * @date : 2022/12/4 20:15
     */
    @RequestMapping("/updateDefaultBill")
    public R updateDefaultBillByBookId(@RequestParam("bookId") Integer bookId){
        logger.info("updateDefaultBill start with bookId:[{}]",bookId);

        billManageService.updateDefaultBill(bookId);
        return R.ok();

    }
}
