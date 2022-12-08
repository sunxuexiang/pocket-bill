package com.cloudfly.start.bill.service.impl;

import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookAnnualSummaryMapper;
import com.cloudfly.start.bill.service.BillBookAnnualSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillBookAnnualSummaryServiceImpl implements BillBookAnnualSummaryService {

    @Autowired
    BillBookAnnualSummaryMapper billBookAnnualSummaryMapper;

    /**
     * @param bookId
     */
    @Override
    public BillBookInfo queryAnnualSummaryList(String bookId) {
        return billBookAnnualSummaryMapper.queryAnnualSummaryList(bookId);
    }
}
