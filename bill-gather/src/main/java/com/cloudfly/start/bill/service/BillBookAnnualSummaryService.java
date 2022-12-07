package com.cloudfly.start.bill.service;

import com.cloudfly.start.bill.entity.BillBookInfo;

public interface BillBookAnnualSummaryService {

    BillBookInfo queryAnnualSummaryList(String bookId);

}
