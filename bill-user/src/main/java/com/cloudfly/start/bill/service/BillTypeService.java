package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillType;
import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.utils.R;

public interface BillTypeService extends IService<BillType>{

   R addType(BillType billType);

   R queryType(int type);

   R removeType(BillType billType);

   R querySystemIcon(int parentId);

}
