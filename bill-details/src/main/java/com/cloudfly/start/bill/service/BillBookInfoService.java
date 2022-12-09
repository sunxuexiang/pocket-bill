package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBookInfo;

import java.util.List;

public interface BillBookInfoService extends IService<BillBookInfo> {

    void addBookInfo(BillBookInfo billBookInfo);

    void updateBookInfoById(BillBookInfo billBookInfo);

    void removeBookInfoById(String bookInfoId);

    List<BillBookInfo> queryBillDetailsCustomize(BillBookInfo billBookInfo);
}
