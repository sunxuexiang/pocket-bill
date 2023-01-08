package com.cloudfly.start.bill.report.service;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.report.base.AbstractBillReportService;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


@Service
public class YearBillReportService extends AbstractBillReportService {
    /**
     * @return Date
     */
    @Override
    public Date countQueryStartTime() {
        return DateUtil.getYearFirstDay(this.getYear());
    }

    /**
     * @return Date
     */
    @Override
    public Date countQueryEndTime() {
        return DateUtil.getYearLastDay(this.getYear());
    }

    /**
     * @Description: 统计年度报表
     * @author lightning
     * @date 2023/1/8 19:03
     * @return Object
     */
    @Override
    public List<Map<String,Object>> generateReport(List<BillBookInfo> reportList) {
        Map<String, BigDecimal> monthMap=new HashMap<>();
        //转换数组
        int[] array=new int[13];
        //循环所有的数据并根据月份相加
        for(BillBookInfo billBookInfo:reportList){
            Date infoDate=billBookInfo.getInfoDate();
            String month=DateUtil.getCurrentMonth(infoDate);
            if(monthMap.get(month)!=null){
                monthMap.put(month,monthMap.get(month).add(billBookInfo.getInfoMoney()));
            }else{
                monthMap.put(month,billBookInfo.getInfoMoney());
            }
            array[Integer.parseInt(month)]=1;
        }
        //其余没有数据的月份统一设置0
        for(int i=1;i<array.length;i++){
            if(array[i]==0) {
                if(i>9){
                    monthMap.put(String.valueOf(i),new BigDecimal(0));
                }else{
                    monthMap.put("0"+i,new BigDecimal(0));
                }
            }
        }
        List<Map<String,Object>> resultList=new ArrayList<>();
        for(String key:monthMap.keySet()){
            Map<String,Object> map=new HashMap<>();
            map.put("month",key);
            map.put("value",monthMap.get(key));
            resultList.add(map);
        }
        Collections.sort(resultList, new Comparator<Map<String,Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return Integer.parseInt(String.valueOf(o1.get("month")))
                        -Integer.parseInt(String.valueOf(o2.get("month")));
            }
        });

        return resultList;
    }

}
