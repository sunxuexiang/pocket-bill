package com.cloudfly.start.bill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookInfoMapper;
import com.cloudfly.start.bill.service.BillBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillBookInfoServiceImpl extends ServiceImpl<BillBookInfoMapper, BillBookInfo> implements BillBookInfoService  {


    @Autowired
    private BillBookInfoMapper billBookInfoMapper;

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
    public void updateBookInfoById(BillBookInfo billBookInfo) {
        this.updateById(billBookInfo);
    }

    /**
     * @param bookInfoId
     */
    @Override
    public void removeBookInfoById(String bookInfoId) {
        this.removeById(bookInfoId);
    }

    /**
     * @Descript
     */
    @Override
    public Map<String,Object> queryBillDetailsCustomize(Integer bookId, Date startTime, Date endTime,
                                                        BigDecimal startMoney, BigDecimal endMoney,String userName) {
        List<BillBookInfo> billBookInfos=billBookInfoMapper.queryBillDetailsCustomize(bookId,startTime,
                endTime, startMoney, endMoney,userName);
        long totalIn=0;
        long totalOut=0;
        for(BillBookInfo bbi:billBookInfos){
            if(bbi.getInfoRapType()==1){
                totalIn+=bbi.getInfoMoney();
            }else{
                totalOut+=bbi.getInfoMoney();
            }
        }
        Map<String,Object> result=new HashMap<>();
        result.put("totalIn",totalIn);
        result.put("totalOut",totalOut);
        result.put(CommonContant.DATA_FIELD,billBookInfos);
        return result;
    }
}
