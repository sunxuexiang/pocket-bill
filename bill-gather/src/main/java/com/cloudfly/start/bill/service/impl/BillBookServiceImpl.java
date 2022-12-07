package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.mapper.BillBookMapper;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.service.BillBookService;
import org.springframework.stereotype.Service;

@Service("billBookService")
public class BillBookServiceImpl extends ServiceImpl<BillBookMapper,BillBook> implements BillBookService {

    @Override
    public String queryById(int id) {
        BillBook byId = this.getById(1);
        return null;
    }
}
