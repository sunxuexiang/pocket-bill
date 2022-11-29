package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.dao.BillBookDao;
import com.cloudfly.start.bill.service.BillBookService;
import org.springframework.stereotype.Service;

@Service("billBookService")
public class BillBookServiceImpl extends ServiceImpl<BillBookDao,BillBook> implements BillBookService {

    @Override
    public String queryById(int id) {
        BillBook byId = this.getById(id);
        return null;
    }
}
