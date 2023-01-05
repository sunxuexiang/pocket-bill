package com.cloudfly.start.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.entity.BillAndUser;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillShare;
import com.cloudfly.start.bill.mapper.BillShareMapper;
import com.cloudfly.start.bill.service.BillShareService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

@Service("billShareService")
public class BillShareServiceImpl extends ServiceImpl<BillShareMapper,BillShare> implements BillShareService{

    @Autowired
    private BillShareMapper billShareMapper;

    @Override
    public List<Map<String,String>> queryUserByBookId(Integer bookId) {
        return billShareMapper.queryUserByBookId(bookId);
    }

    @Override
    public void addShare(BillShare billShare) {
        billShare.setShareUserId(JwtUtils.getCurrentLoginUser());
        baseMapper.insert(billShare);

    }

    @Override
    public void updateUserBillPermession(Integer shareId,Integer sharePower) {
        billShareMapper.updateUserBillPermession(shareId, sharePower,JwtUtils.getCurrentLoginUser());
    }

    /**
     * @param shareId
     */
    @Override
    public void deleteUserBillPermission(Integer shareId) {
        billShareMapper.deleteById(shareId);
    }

    /**
     * @param bookId
     * @return
     */
    @Override
    public BillBook queryBillByBookIdAndUserId(Integer bookId) {
        return billShareMapper.queryBillByBookIdAndUserId(bookId,JwtUtils.getCurrentLoginUser());
    }

    /**
     * @param bookId
     */
    @Override
    public void updateShareBillBatch(Integer bookId,Integer sharePower) {
        billShareMapper.updateShareBillBatch(bookId, sharePower);
    }

}
