package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.utils.R;

import java.util.List;

public interface BillManageService extends IService<BillBook>{

    R addBillManage(BillBook billBook);

    R updateBillManage(BillBook billBook);

    R queryByBillId(Integer userId);

    List<BillBook> queryBillByUserId();

    BillBook queryDefaultBillByUserId();

    void updateDefaultBill(Integer bookId);

}
