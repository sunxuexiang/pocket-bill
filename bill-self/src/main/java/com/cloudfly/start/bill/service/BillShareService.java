package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.utils.R;

import java.util.List;

public interface BillShareService extends IService<BillShare>{

    R queryByBillAndUserId(Integer billId);

    R addShare(BillShare billShare);

    R updateShareByBill(BillShare list);

}
