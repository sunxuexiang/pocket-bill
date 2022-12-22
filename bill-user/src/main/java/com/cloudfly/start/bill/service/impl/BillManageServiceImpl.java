package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.mapper.BillBookMapper;
import com.cloudfly.start.bill.service.BillManageService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billManageService")
public class BillManageServiceImpl extends ServiceImpl<BillBookMapper,BillBook> implements BillManageService{


    @Autowired
    private BillBookMapper billBookMapper;
    @Override
    public R addBillManage(BillBook billBook) {
        Integer currentLoginUser = JwtUtils.getCurrentLoginUser();
        billBook.setUserId(currentLoginUser);
        if (baseMapper.insert(billBook) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Override
    public R updateBillManage(BillBook billBook) {
        if (baseMapper.updateById(billBook) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Override
    public R queryByBillId(Integer billId) {
        BillBook billBook = baseMapper.selectById(billId);
        return R.ok(billBook);
    }

    @Override
    public List<BillBook> queryBillByUserId() {
        return baseMapper.queryBillByUserId(JwtUtils.getCurrentLoginUser());
    }

    /**
     * @param
     * @return
     */
    @Override
    public BillBook queryDefaultBillByUserId() {
        return billBookMapper.queryDefaultBillByUserId(JwtUtils.getCurrentLoginUser());
    }

    /**
     *
     */
    @Override
    public void updateDefaultBill(Integer bookId) {
        billBookMapper.updateBillBookByUserId(JwtUtils.getCurrentLoginUser());
        billBookMapper.updateBillBookByBookId(bookId);

    }

}
