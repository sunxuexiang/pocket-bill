package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;


public interface BillBookService extends IService<BillBook>{

    public String queryById(int id);
}
