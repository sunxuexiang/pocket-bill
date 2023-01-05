package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName( "bill_book_info")
public class BillBookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;
    private Integer userId;
    private Integer bookId;
    private String payName;
    private Integer typeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal infoMoney;
    private String infoImg;
    private int infoPayType;
    private Date infoDate;
    private String infoRemark;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }


    public int getInfoPayType() {
        return infoPayType;
    }

    public void setInfoPayType(int infoPayType) {
        this.infoPayType = infoPayType;
    }

    public BigDecimal getInfoMoney() {
        return infoMoney;
    }

    public void setInfoMoney(BigDecimal infoMoney) {
        this.infoMoney = infoMoney;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }

    public String getInfoRemark() {
        return infoRemark;
    }

    public void setInfoRemark(String infoRemark) {
        this.infoRemark = infoRemark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "BillBookInfo{" +
                "infoId=" + infoId +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", payName='" + payName + '\'' +
                ", typeId='" + typeId + '\'' +
                ", infoMoney=" + infoMoney +
                ", infoImg='" + infoImg + '\'' +
                ", infoPayType=" + infoPayType +
                ", infoDate=" + infoDate +
                ", infoRemark='" + infoRemark + '\'' +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", updateDate=" + updateDate +
                ", updateBy=" + updateBy +
                '}';
    }
}
