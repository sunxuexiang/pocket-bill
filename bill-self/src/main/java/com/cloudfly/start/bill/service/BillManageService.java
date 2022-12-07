package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.utils.R;

public interface BillManageService extends IService<BillBook>{

    R addBillManage(BillBook billBook);

    R updateBillManage(BillBook billBook);

    R queryByBillId(Integer billId);

    R queryByUserIdList();
}
