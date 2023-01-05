package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.utils.R;

import java.util.List;
import java.util.Map;

public interface BillShareService extends IService<BillShare>{

    List<Map<String,String>> queryUserByBookId(Integer bookId);

    void addShare(BillShare billShare);

    void updateUserBillPermession(Integer shareId,Integer sharePower);

    void deleteUserBillPermission(Integer shareId);

    BillBook queryBillByBookIdAndUserId(Integer bookId);

    void updateShareBillBatch(Integer bookId,Integer sharePower);

}
