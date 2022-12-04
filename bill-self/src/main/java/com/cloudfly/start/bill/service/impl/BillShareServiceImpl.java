package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.dao.BillAndUserDao;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.mapper.BillShareMapper;
import com.cloudfly.start.bill.service.BillShareService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billShareService")
public class BillShareServiceImpl extends ServiceImpl<BillShareMapper,BillShare> implements BillShareService{

    @Autowired
    private BillManageServiceImpl billManageService;

    @Override
    public R queryByBillAndUserId(Integer billId) {
        BillBook byId = billManageService.getById(billId);
        BillAndUserDao billAndUserDao = baseMapper.queryByBillAndUserId(billId);
        billAndUserDao.setBillBook(byId);
        return R.ok(billAndUserDao);
    }

    @Override
    public R addShare(BillShare billShare) {
        billShare.setShareUserId(JwtUtils.getCurrentLoginUser());
        if (baseMapper.insert(billShare) > 0) {
            return R.ok("添加成功");
        }
        return R.error();
    }

    @Override
    public R updateShareByBill(BillShare share) {
        if (baseMapper.updateById(share) > 0) {
            return R.ok("添加成功");
        }
        return R.error();
    }
}
