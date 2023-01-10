package com.cloudfly.start.bill.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description : TODO
 * @author: Hulk
 * @date : 1016:37
 */
public class BillBookInfoEntity {
    private static final long serialVersionUID = 1L;

    private Integer infoId;
    private Integer userId;
    private Integer bookId;
    private String payName;
    private Integer typeId;
    private BigDecimal infoMoney;
    private String infoImg;
    private int infoPayType;
    private String typeName;
    private Date infoDate;
    private String infoRemark;
    private Date createDate;
    private Integer createBy;
    private Date updateDate;
    private Integer updateBy;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
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

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    public int getInfoPayType() {
        return infoPayType;
    }

    public void setInfoPayType(int infoPayType) {
        this.infoPayType = infoPayType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
