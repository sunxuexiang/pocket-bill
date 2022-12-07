package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName( "bill_book_info")
public class BillBookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer infoId;
    private String infoUserId;
    private String infoBookId;
    private String infoPayId;
    private String infoTypeId;
    private Double infoMoney;
    private String infoImg;
    private int infoReType;
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

    public String getInfoUserId() {
        return infoUserId;
    }

    public void setInfoUserId(String infoUserId) {
        this.infoUserId = infoUserId;
    }

    public String getInfoBookId() {
        return infoBookId;
    }

    public void setInfoBookId(String infoBookId) {
        this.infoBookId = infoBookId;
    }

    public String getInfoPayId() {
        return infoPayId;
    }

    public void setInfoPayId(String infoPayId) {
        this.infoPayId = infoPayId;
    }

    public String getInfoTypeId() {
        return infoTypeId;
    }

    public void setInfoTypeId(String infoTypeId) {
        this.infoTypeId = infoTypeId;
    }

    public Double getInfoMoney() {
        return infoMoney;
    }

    public void setInfoMoney(Double infoMoney) {
        this.infoMoney = infoMoney;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }

    public int getInfoReType() {
        return infoReType;
    }

    public void setInfoReType(int infoReType) {
        this.infoReType = infoReType;
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
}
