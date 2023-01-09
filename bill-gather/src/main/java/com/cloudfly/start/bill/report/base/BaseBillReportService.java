package com.cloudfly.start.bill.report.base;

import com.cloudfly.start.bill.entity.BillBookInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BaseBillReportService {

     void setReportBaseData(Integer infoPayType,int year,int month);

     Map<String,Object> billDataClassifyByDate(List<BillBookInfo> reportList, int[] array);
}
