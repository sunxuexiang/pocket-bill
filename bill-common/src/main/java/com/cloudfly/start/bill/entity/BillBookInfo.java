package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName( "bill_book_info")
public class BillBookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer infoId;
    private String userId;
    private String bookId;
    private String payId;
    private String typeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal infoMoney;
    private String infoImg;
    private int infoRapType;
    private Date infoDate;
    private String infoRemark;
    private Date createDate;
    private Integer createBy;
    private Date updateDate;
    private Integer updateBy;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getInfoRapType() {
        return infoRapType;
    }

    public void setInfoRapType(int infoRapType) {
        this.infoRapType = infoRapType;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "BillBookInfo{" +
                "infoId=" + infoId +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", payId='" + payId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", infoMoney=" + infoMoney +
                ", infoImg='" + infoImg + '\'' +
                ", infoRapType=" + infoRapType +
                ", infoDate=" + infoDate +
                ", infoRemark='" + infoRemark + '\'' +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", updateDate=" + updateDate +
                ", updateBy=" + updateBy +
                '}';
    }
}
