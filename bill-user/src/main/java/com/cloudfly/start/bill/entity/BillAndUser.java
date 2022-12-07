package com.cloudfly.start.bill.entity;

import java.util.List;

public class BillAndUser {

    private BillBook billBook;
    private List<BillShareBase> billUsers;

    public BillBook getBillBook() {
        return billBook;
    }

    public void setBillBook(BillBook billBook) {
        this.billBook = billBook;
    }

    public List<BillShareBase> getBillUsers() {
        return billUsers;
    }

    public void setBillUsers(List<BillShareBase> billUsers) {
        this.billUsers = billUsers;
    }
}
