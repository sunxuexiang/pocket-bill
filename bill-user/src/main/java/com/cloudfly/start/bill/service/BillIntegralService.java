package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillIntegral;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.utils.R;

public interface BillIntegralService extends IService<BillIntegral>{

    int addIntegral(BillIntegral billIntegral);
    R queryIntegralByUserId();

}
