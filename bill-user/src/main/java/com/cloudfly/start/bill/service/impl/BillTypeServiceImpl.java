package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.entity.BillAndUser;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.entity.BillType;
import com.cloudfly.start.bill.mapper.BillShareMapper;
import com.cloudfly.start.bill.mapper.BillTypeMapper;
import com.cloudfly.start.bill.service.BillShareService;
import com.cloudfly.start.bill.service.BillTypeService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("billTypeService")
public class BillTypeServiceImpl extends ServiceImpl<BillTypeMapper,BillType> implements BillTypeService{

    @Override
    public R addType(BillType billType) {
        int insert = baseMapper.insert(billType);
        if (insert >=1 )
            return R.ok();
        return R.error();
    }

    @Override
    public R queryType(int type) {
        return R.ok(baseMapper.selectList(new LambdaQueryWrapper<BillType>().eq(BillType::getType,type)));
    }
}
