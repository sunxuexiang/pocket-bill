package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.exception.BillSystemException;
import com.cloudfly.start.bill.service.BillShareService;
import com.cloudfly.start.bill.utils.R;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill-share")
public class BillShareController {

    private Logger logger= LoggerFactory.getLogger(BillShareController.class);

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

    public R updateShareBillBatch(@RequestParam("bookId")Integer bookId,@RequestParam("sharePower") Integer sharePower){
       logger.info("updateShareBillBatch start with bookId:[{}],sharePower:[{}]",bookId,sharePower);
        BillBook bb= billShareService.queryBillByBookIdAndUserId(bookId);
        if(null!=bb){
            billShareService.updateShareBillBatch(bookId);
            return R.ok();
        }else{
            logger.info("current user don't has permession to operate this book with id:[{}]",bookId);
            return R.error("您没有共享此账本的权限！请联系管理管！！");
        }
    }
}
