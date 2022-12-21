package com.cloudfly.start.bill.service.impl;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookAnnualSummaryMapper;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BillBookAnnualSummaryServiceImpl implements BillBookAnnualSummaryService {

    @Autowired
    BillBookAnnualSummaryMapper billBookAnnualSummaryMapper;

    /**
     * @param bookId
     */
    @Override
    public Map<String,Object> queryAnnualSummaryReportList(int bookId,int year) {

        Date startTime= DateUtil.getYearFirst(year);
        Date endTime= DateUtil.getYearLast(year);
        List<Map<String,Integer>> resultMap=billBookAnnualSummaryMapper.queryAnnualSummaryReportList(bookId,startTime,endTime);
        BigDecimal yearTotalIn=new BigDecimal(0);
        BigDecimal yearTotalOut=new BigDecimal(0);
        for(Map<String,Integer> map:resultMap){
            yearTotalIn=yearTotalIn.add(new BigDecimal(map.get("monthIn").toString()));
            yearTotalOut=yearTotalOut.add(new BigDecimal(Integer.parseInt(map.get("monthOut").toString())));
        }
        Map<String,Object> result=new HashMap<>();
        result.put("yearTotalIn",yearTotalIn);
        result.put("yearTotalOut",yearTotalOut);
        result.put("yearTotalBalance",yearTotalIn.subtract(yearTotalOut));
        result.put("data",resultMap);
        return result;
    }
}
