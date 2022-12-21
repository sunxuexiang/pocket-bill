package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.Bill;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillManageService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang.exception.ExceptionUtils;
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

    @RequestMapping("/queryDefaultBillByUserId")
    public R queryDefaultBillByUserId(@RequestParam("billId") Integer userId) {
        logger.info("queryDefaultBillByUserId start with userId : [{}]",userId);
        try{
            return R.ok().put(CommonContant.RESPONSE_FIELD,billManageService.queryDefaultBillByUserId(userId));
        }catch (Exception e){
            logger.error("queryDefaultBillByUserId occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }


    /**
     * @Description : 查询当前用户所有相关账单
     * @author: Hulk
     * @date : 2022/12/4 20:15
     */
    @RequestMapping("/queryBillByUserId")
    public R queryBillByUserId(){
        List<Bill> list=new ArrayList<>();
        Bill bill1=new Bill();
        bill1.setBillId(1);
        bill1.setBookName("增加");
        bill1.setCreateDate(new Date());
        Bill bill2=new Bill();
        bill2.setBillId(2);
        bill2.setBookName("删除");
        bill2.setCreateDate(new Date());
        Bill bill3=new Bill();
        bill3.setBillId(3);
        bill3.setBookName("查询");
        bill3.setCreateDate(new Date());
        Bill bill4=new Bill();
        bill4.setBillId(4);
        bill4.setBookName("修改");
        bill4.setCreateDate(new Date());
        list.add(bill1);
        list.add(bill2);
        list.add(bill3);
        list.add(bill4);
        return R.ok().put("result",list);
        //return billManageService.queryByUserIdList();
    }
}
