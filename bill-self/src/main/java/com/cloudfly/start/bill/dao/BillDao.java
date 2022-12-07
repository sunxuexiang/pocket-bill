package com.cloudfly.start.bill.dao;

import java.util.Date;

/**
 * @Description : 账单管理页面Dao
 * @author: Hulk
 * @date : 0420:02
 */
public class BillDao {

    private Integer billId;
    private Integer bookType;
    private String bookName;
    private Date createDate;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
