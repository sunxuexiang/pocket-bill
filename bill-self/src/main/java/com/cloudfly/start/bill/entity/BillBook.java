package com.cloudfly.start.bill.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("bill_book")
public class BillBook implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int bookId;
    private int userId;
    private String bookType;
    private String bookName;
    private Date createDate;
    private int createBy;
    private Date updateDate;
    private int updateBy;

}
