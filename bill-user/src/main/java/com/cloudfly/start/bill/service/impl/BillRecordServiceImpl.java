package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.entity.*;
import com.cloudfly.start.bill.mapper.BillRecordMapper;
import com.cloudfly.start.bill.mapper.BillRoutMapper;
import com.cloudfly.start.bill.service.BillIntegralService;
import com.cloudfly.start.bill.service.BillRecordService;
import com.cloudfly.start.bill.service.BillUserService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("billRecordService")
public class BillRecordServiceImpl extends ServiceImpl<BillRecordMapper,BillRecord> implements BillRecordService{

    @Autowired
    private BillIntegralService billIntegralService;
    @Autowired
    private BillUserService billUserService;
    @Autowired
    private BillRoutMapper billRoutMapper;

    @Override
    public R addRecord() {
        Integer currentLoginUser = JwtUtils.getCurrentLoginUser();
        BillRecord billRecord = new BillRecord();
        billRecord.setRecordUserId(currentLoginUser);
        if (baseMapper.insert(billRecord) > 0) {
            // 添加积分记录
            BillIntegral billIntegral = new BillIntegral();
            billIntegral.setIntegralInfo("用户打卡添加积分");
            billIntegralService.addIntegral(billIntegral);

            // 查询打卡记录积分规则
            BillRout billRout = billRoutMapper.selectOne(new LambdaQueryWrapper<BillRout>().eq(BillRout::getRoutType, 1));

            // 查询当前用户积分
            BillUser byId = billUserService.getById(JwtUtils.getCurrentLoginUser());
            byId.setUserIntegral(byId.getUserIntegral()+billRout.getRoutValue());
            billUserService.updateById(byId);
            return R.ok();
        }
        return R.error();
    }

    @Override
    public R querRecordByUserId() {
        int count =  baseMapper.selectCount(new LambdaQueryWrapper<BillRecord>().eq(BillRecord::getRecordUserId, JwtUtils.getCurrentLoginUser()));
        return R.ok(count);
    }
}
