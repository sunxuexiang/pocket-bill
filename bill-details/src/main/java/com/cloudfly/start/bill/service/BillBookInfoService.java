package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBookInfo;

public interface BillBookInfoService extends IService<BillBookInfo> {

    void addBookInfo(BillBookInfo billBookInfo);

    void updateBookInfo(BillBookInfo billBookInfo);

    void removeBookInfo(String bookInfoId);
}