package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillBookInfoService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/queryBillDetailsCustomize")
    public R queryBillDetailsCustomize(@RequestBody BillBookInfo billBookInfo){
        logger.info("queryBillDetailsCustomize start with data : [{}]",billBookInfo.toString());
        try{
            List<BillBookInfo> billBookInfos = billBookInfoService.queryBillDetailsCustomize(billBookInfo);
            long totalIn=0;
            long totalOut=0;
            for(BillBookInfo bbi:billBookInfos){
                if(bbi.getInfoRapType()==1){
                    totalIn+=bbi.getInfoMoney();
                }else{
                    totalOut+=bbi.getInfoMoney();
                }
            }
            return R.ok().put("result",billBookInfos).put("totalIn",totalIn).put("totalOut",totalOut);
        }catch (Exception e){
            logger.error("queryBillDetailsCustomize occured exception : {}", ExceptionUtils.getStackTrace(e));
            throw new BillSystemException(e.getMessage());
        }
    }
}
