package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillBookInfoService;
import com.cloudfly.start.bill.utils.DateUtil;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: pocket-bill
 * @BelongsPackage: com.cloudfly.start.bill.controller
 * @Author: wangyun
 * @CreateTime: 2022-12-07  14:14
 * @Description: 账本详情的增删改查
 */
@RequestMapping("/billBookInfoController")
@RestController
public class BillBookInfoController{

    private static Logger logger= LoggerFactory.getLogger(BillBookInfoController.class);

    @Autowired
    BillBookInfoService billBookInfoService;

    @RequestMapping("/addBookInfo")
    public void addBookInfo(@RequestBody BillBookInfo billBookInfo){
        billBookInfoService.addBookInfo(billBookInfo);
    }

    @RequestMapping("/updateBookInfo")
    public void updateBookInfoById(@RequestBody BillBookInfo billBookInfo){
        billBookInfoService.updateBookInfoById(billBookInfo);
    }

    @RequestMapping("/removeBookInfo")
    public void removeBookInfoById(@RequestParam("bookInfoId") String bookInfoId){
        billBookInfoService.removeBookInfoById(bookInfoId);
    }

    /**
     * @Description用户自定义查询账单
     * */
    @RequestMapping("/queryBillDetailsCustomize")
    public R queryBillDetailsCustomize(@RequestParam("bookId")Integer bookId, @RequestParam(value="bookContent",required = false)String bookContent,
                                       @RequestParam(value="startTime",required = false) Date startTime, @RequestParam(value="endTime",required = false)Date endTime,
                                       @RequestParam(value="startMoney",required = false)BigDecimal startMoney, @RequestParam(value="endMoney",required = false)BigDecimal endMoney,
                                       @RequestParam(value="userName",required = false)String userName){
        logger.info("queryBillDetailsCustomize start with bookId:[{}],startTime:[{}],endTime:[{}]" +
                ",startMoney:[{}],endMoney:[{}],userName:[[]]",bookId,startTime,endTime,startMoney,endMoney,userName);
        try{
            return R.ok().put(CommonContant.RESPONSE_FIELD,
                    billBookInfoService.queryBillDetailsCustomize(bookId, startTime, endTime, startMoney,endMoney,userName));
        }catch (Exception e){
            logger.error("queryBillDetailsCustomize occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getMonthLastDay(2019,2));
    }
}
