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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   @RequestMapping("/queryUserByBookId")
   public R queryUserByBookId(@RequestParam("bookId") Integer bookId){
//       select user_id userId,
//               user_name userName,
//               user_img userImg,
//               t.book_id t.bookId,
//               t.is_admin isAdmin
       List<Map<String,String>> result=new ArrayList<>();
       for(int i=0;i<4;i++){
           Map<String,String> map=new HashMap<>();
           map.put("userId",(i+1)+"");
           map.put("userName","老王大哥");
           map.put("userImg","../../../static/wechat.jpg");
           map.put("bookId",(i+1)+"");

           if(i==0){
               map.put("sharePower","0");
           }else{
               map.put("sharePower","1");
           }
           if(i==2){
               map.put("sharePower","2");
           }
           result.add(map);
       }


       return R.ok().put(CommonContant.RESPONSE_FIELD,result);
   }

    /**
    * @Description : 账单共享页面添加其他共享人
    * @author: Hulk
    * @date : 2022/12/4 19:59
    */
    @RequestMapping("/addShare")
    public R addShare(BillShare billShare) {
        billShareService.addShare(billShare);
        return R.ok();
    }

    /**
    * @Description : 修改共享账单人权限
    * @author: Hulk
    * @date : 2022/12/4 20:00
    */
    @RequestMapping("/updateUserBillPermession")
    public R updateUserBillPermession(@RequestParam("shareId") Integer shareId, @RequestParam("sharePower") Integer sharePower) {
        logger.info("updateUserBillPermession start with shareId:[{}],userId:[{}],sharePower:[{}]",
                shareId, sharePower);
        billShareService.updateUserBillPermession(shareId,sharePower);
        return R.ok();
    }

    public R deleteUserBillPermission(@RequestParam("shareId") Integer shareId){
        billShareService.deleteUserBillPermission(shareId);
        return R.ok();
    }

    public R updateShareBillBatch(@RequestParam("bookId")Integer bookId,@RequestParam("sharePower") Integer sharePower){
        logger.info("updateShareBillBatch start with bookId:[{}],sharePower:[{}]",bookId,sharePower);
        BillBook bb= billShareService.queryBillByBookIdAndUserId(bookId);
        if(null!=bb){
            billShareService.updateShareBillBatch(bookId,sharePower);
            return R.ok();
        }else{
            logger.info("current user don't has permession to operate this book with id:[{}]",bookId);
            return R.error("您没有共享此账本的权限！请联系管理管！！");
        }
    }
}
