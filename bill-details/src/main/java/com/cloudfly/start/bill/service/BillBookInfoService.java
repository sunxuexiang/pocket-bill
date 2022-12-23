package com.cloudfly.start.bill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloudfly.start.bill.entity.BillBookInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillBookInfoService extends IService<BillBookInfo> {

    void addBookInfo(BillBookInfo billBookInfo);

    void updateBookInfoById(BillBookInfo billBookInfo);

    void removeBookInfoById(String bookInfoId);

    Map<String,Object> queryBillDetailsCustomize(Integer bookId, String infoRemark,Date startTime, Date endTime,
                                                 BigDecimal startMoney, BigDecimal endMoney,String userName);
}
