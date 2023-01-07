package com.cloudfly.start.bill.service.impl;

import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookAnnualSummaryMapper;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
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

        Date startTime= DateUtil.getYearFirstDay(year);
        Date endTime= DateUtil.getYearLastDay(year);
        List<Map<String,BigDecimal>> resultList=billBookAnnualSummaryMapper.queryAnnualSummaryReportList(bookId,startTime,endTime);
        BigDecimal yearTotalIn=new BigDecimal(0);
        BigDecimal yearTotalOut=new BigDecimal(0);
        int[] array=new int [13];
        for(Map<String,BigDecimal> map:resultList){
            if (map.get("monthIn") != null) {
                BigDecimal monthIn=map.get("monthIn").setScale(2, RoundingMode.HALF_UP);
                yearTotalIn=yearTotalIn.add(monthIn);
            }
            if (map.get("monthOut") != null) {
                yearTotalOut=yearTotalOut.add(map.get("monthOut").setScale(2, RoundingMode.HALF_UP));
            }
            String billMonth=String.valueOf(map.get("billMonth"));
            array[Integer.parseInt(billMonth)]=1;
        }
        for(int i=1;i<array.length;i++){
            if(array[i]==0){
                Map<String,BigDecimal> generateMap=new HashMap<>();
                generateMap.put("bookId",new BigDecimal(bookId+""));
                generateMap.put("billMonth",new BigDecimal(i+""));
                generateMap.put("monthIn",new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                generateMap.put("monthOut",new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                generateMap.put("balance",new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                resultList.add(generateMap);
            }
        }
        Map<String,Object> result=new HashMap<>();
        result.put("yearTotalIn",yearTotalIn.setScale(2, RoundingMode.HALF_UP));
        result.put("yearTotalOut",yearTotalOut.setScale(2, RoundingMode.HALF_UP));
        result.put("yearTotalBalance",yearTotalIn.subtract(yearTotalOut).setScale(2, RoundingMode.HALF_UP));

        Collections.sort(resultList, new Comparator<Map<String,BigDecimal>>() {
            @Override
            public int compare(Map<String, BigDecimal> o1, Map<String, BigDecimal> o2) {
                return Integer.parseInt(String.valueOf(o2.get("billMonth")))
                        -Integer.parseInt(String.valueOf(o1.get("billMonth")));
            }
        });

        result.put(CommonContant.DATA_FIELD,resultList);

        return result;
    }
}
