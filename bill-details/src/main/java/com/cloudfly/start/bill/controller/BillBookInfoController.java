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
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    /**
     * @Description: 新增账单明细
     * @author lightning
     * @date 2022/12/24 11:39
     */
    @RequestMapping("/addBookInfo")
    public void addBookInfo(@RequestBody BillBookInfo billBookInfo){
        billBookInfoService.addBookInfo(billBookInfo);
    }

    /**
     * @Description: 修改账单明细
     * @author lightning
     * @date 2022/12/24 11:40
     */
    @RequestMapping("/updateBookInfo")
    public void updateBookInfoById(@RequestBody BillBookInfo billBookInfo){
        billBookInfoService.updateBookInfoById(billBookInfo);
    }

    /**
     * @Description: 删除账单明细
     * @author lightning
     * @date 2022/12/24 11:40
     */
    @RequestMapping("/removeBookInfo")
    public void removeBookInfoById(@RequestParam("bookInfoId") String bookInfoId){
        billBookInfoService.removeBookInfoById(bookInfoId);
    }

    /**
     * @Description用户自定义查询账单
     * */
    @RequestMapping("/queryBillDetailsCustomize")
    public R queryBillDetailsCustomize(@RequestParam("bookId")Integer bookId, @RequestParam(value="infoRemark",required = false)String infoRemark,
                                       @RequestParam(value="startTime",required = false) String startTime, @RequestParam(value="endTime",required = false)String endTime,
                                       @RequestParam(value="startMoney",required = false)BigDecimal startMoney, @RequestParam(value="endMoney",required = false)BigDecimal endMoney,
                                       @RequestParam(value="userName",required = false)String userName) throws ParseException {
        logger.info("queryBillDetailsCustomize start with bookId:[{}],infoRemak:[{}],startTime:[{}],endTime:[{}]" +
                ",startMoney:[{}],endMoney:[{}],userName:[[]]",bookId,infoRemark,startTime,endTime,startMoney,endMoney,userName);

            SimpleDateFormat sdf=new SimpleDateFormat(DateUtil.DATE_TIME_PATTERN);

            return R.ok().put(CommonContant.RESPONSE_FIELD,
                    billBookInfoService.queryBillDetailsCustomize(bookId, infoRemark,sdf.parse(startTime),
                            sdf.parse(endTime), startMoney,endMoney,userName));

    }
}
