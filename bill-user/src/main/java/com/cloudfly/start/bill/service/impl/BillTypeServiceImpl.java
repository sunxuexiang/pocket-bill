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
import java.util.List;

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
        List<BillType> billTypes = baseMapper.queryList(JwtUtils.getCurrentLoginUser(),type);
        return R.ok(billTypes);
    }

    @Override
    public R removeType(BillType billType) {
        // 查询当前删除类型
        BillType billType1 = baseMapper.selectById(billType.getTypeId());
        if (billType1.getUserId() == 9999) {
            // 表示为系统图标 增加一个记录
            billType.setTypeId(0);
            billType.setType(billType1.getType());
            billType.setTypeIcon(billType1.getTypeIcon());
            billType.setIsDelete(1);
            billType.setTypeName(billType1.getTypeName());
            billType.setUserId(JwtUtils.getCurrentLoginUser());
            billType.setParentId(billType1.getTypeId());
            if (baseMapper.insert(billType) > 0) {
                return R.ok();
            }
        } else {
            billType.setIsDelete(1);
            if (baseMapper.updateById(billType) > 0) {
                return R.ok();
            }
        }
        return R.error();
    }
}
