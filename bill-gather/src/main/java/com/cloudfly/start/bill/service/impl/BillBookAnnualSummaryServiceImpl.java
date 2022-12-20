package com.cloudfly.start.bill.service.impl;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookAnnualSummaryMapper;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Map<String,String>> queryAnnualSummaryReportList(String bookId) {
        return billBookAnnualSummaryMapper.queryAnnualSummaryReportList(bookId);
    }
}
