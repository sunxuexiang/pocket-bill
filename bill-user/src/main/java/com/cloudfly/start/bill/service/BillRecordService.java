package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillRecord;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.utils.R;

public interface BillRecordService extends IService<BillRecord>{

    R addRecord();

    R querRecordByUserId();

}
