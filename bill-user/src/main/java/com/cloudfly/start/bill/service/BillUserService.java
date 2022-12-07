package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.utils.R;

public interface BillUserService extends IService<BillUser>{

     R Login(String code) throws Exception;

     R addUser(BillUser billUser);

}
