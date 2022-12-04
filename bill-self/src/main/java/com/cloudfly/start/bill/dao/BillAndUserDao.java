package com.cloudfly.start.bill.dao;

import com.cloudfly.start.bill.entity.BillBook;

import java.util.List;

public class BillAndUserDao {

    private BillBook billBook;
    private List<BillShareDao> billUsers;

    public BillBook getBillBook() {
        return billBook;
    }

    public void setBillBook(BillBook billBook) {
        this.billBook = billBook;
    }

    public List<BillShareDao> getBillUsers() {
        return billUsers;
    }

    public void setBillUsers(List<BillShareDao> billUsers) {
        this.billUsers = billUsers;
    }
}
