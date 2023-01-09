package com.cloudfly.start.bill.report.base;



import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookReportGatherMapper;
import com.cloudfly.start.bill.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class AbstractBillReportService implements BaseBillReportService {

    @Autowired
    private BillBookReportGatherMapper billReportMapper;

    private Integer infoPayType;

    private int year;

    private int month;

    public Integer getInfoPayType() {
        return infoPayType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setReportBaseData(Integer infoPayType,int year,int month) {
        this.infoPayType=infoPayType;
        this.year=year;
        this.month=month;
    }

    public Map<String,Object> generateReport(Integer bookId,Integer infoPayType,int year,int month){
        this.setReportBaseData(infoPayType,year,month);
        Date startTime=countQueryStartTime();
        Date endTime=countQueryEndTime();
        return generateReportBySelf(billReportMapper.generateReport(bookId,startTime,endTime,infoPayType));
    }
    /**
     * @Description: 计算报表查询开始时间
     * @author lightning
     * @date 2022/12/24 11:44
     * @return Date
     */
    public abstract Date countQueryStartTime();

    /**
     * @Description: 计算报表查询结束时间
     * @author lightning
     * @date 2022/12/24 11:44
     * @return Date
     */
    public abstract Date countQueryEndTime();

    /**
     * @Description: 对年月周数据生成报表
     * @author lightning
     * @date 2023/1/9 9:54
     * @return List<Map<Object>>
     */
    public abstract Map<String,Object> generateReportBySelf(List<BillBookInfo> reportList);

    /**
     * @Description: 根据年，月，日分类统计，生成报表数据
     * @author lightning
     * @date 2023/1/9 10:01
     * @return List<Map<Object>>
     */
    @Override
    public Map<String,Object> billDataClassifyByDate(List<BillBookInfo> reportList,int[] array){

        Map<String, BigDecimal> classifyMap=new HashMap<>();
        BigDecimal total=new BigDecimal(0);
        //循环所有的数据并根据月份相加
        for(BillBookInfo billBookInfo:reportList){
            Date infoDate=billBookInfo.getInfoDate();
            String date=getMonthOrDayOrWeek(infoDate);
            BigDecimal infoMoney=billBookInfo.getInfoMoney();
            total=total.add(infoMoney);
            if(classifyMap.get(date)!=null){
                classifyMap.put(date,classifyMap.get(date).add(infoMoney));
            }else{
                classifyMap.put(date,billBookInfo.getInfoMoney());
            }
            //排除已经统计过的时间
            array[Integer.parseInt(date)]=1;
        }
        total=total.setScale(2, RoundingMode.HALF_UP);
        //其余没有数据的时间统一设置0
        for(int i=1;i<array.length;i++){
            if(array[i]==0) {
                if(i>9){
                    classifyMap.put(String.valueOf(i),new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                }else{
                    classifyMap.put("0"+i,new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                }
            }
        }
        //封装所有数据到list
        List<Map<String,Object>> resultList=new ArrayList<>();
        for(String key:classifyMap.keySet()){
            Map<String,Object> map=new HashMap<>();
            map.put("date",key);
            map.put("value",classifyMap.get(key));
            resultList.add(map);
        }
        //根据日期排序
        Collections.sort(resultList, new Comparator<Map<String,Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return Integer.parseInt(String.valueOf(o1.get("date")))
                        -Integer.parseInt(String.valueOf(o2.get("date")));
            }
        });
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put(CommonContant.RESPONSE_FIELD,resultList);
        return resultMap;
    }

    public abstract String getMonthOrDayOrWeek(Date date);
}
