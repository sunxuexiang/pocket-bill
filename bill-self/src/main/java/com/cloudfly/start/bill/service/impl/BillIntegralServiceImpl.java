package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.entity.BillIntegral;
import com.cloudfly.start.bill.entity.BillRecord;
import com.cloudfly.start.bill.mapper.BillIntegralMapper;
import com.cloudfly.start.bill.mapper.BillRecordMapper;
import com.cloudfly.start.bill.service.BillIntegralService;
import com.cloudfly.start.bill.service.BillRecordService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("billIntegralService")
public class BillIntegralServiceImpl extends ServiceImpl<BillIntegralMapper,BillIntegral> implements BillIntegralService{

    @Override
    public int addIntegral(BillIntegral billIntegral) {
        billIntegral.setIntegralUserId(JwtUtils.getCurrentLoginUser());
        return baseMapper.insert(billIntegral);
    }

    @Override
    public R queryIntegralByUserId() {
        List<BillIntegral> billIntegrals = baseMapper.selectList(new LambdaQueryWrapper<BillIntegral>().eq(BillIntegral::getIntegralUserId, JwtUtils.getCurrentLoginUser()));
        return R.ok(billIntegrals);
    }
}
