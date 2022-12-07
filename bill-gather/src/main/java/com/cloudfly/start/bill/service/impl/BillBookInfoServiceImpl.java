package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.dao.BillBookInfoDao;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.service.BillBookInfoService;

public class BillBookInfoServiceImpl extends ServiceImpl<BillBookInfoDao, BillBookInfo> implements BillBookInfoService {
    /**
     * @param billBookInfo
     */
    @Override
    public void addBookInfo(BillBookInfo billBookInfo) {
        this.save(billBookInfo);
    }

    /**
     * @param billBookInfo
     */
    @Override
    public void updateBookInfo(BillBookInfo billBookInfo) {
        this.updateById(billBookInfo);
    }

    /**
     * @param bookInfoId
     */
    @Override
    public void removeBookInfo(String bookInfoId) {
        this.removeById(bookInfoId);
    }
}
