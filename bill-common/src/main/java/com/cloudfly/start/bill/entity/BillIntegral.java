package com.cloudfly.start.bill.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName(value = "bill_integral")
public class BillIntegral {

    @TableId
    private Integer integralId;
    private Integer integralUserId;
    private String integralInfo;
    private Date createDate;
    private int createBy;
    private Date updateDate;
    private int updateBy;

    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public Integer getIntegralUserId() {
        return integralUserId;
    }

    public void setIntegralUserId(Integer integralUserId) {
        this.integralUserId = integralUserId;
    }

    public String getIntegralInfo() {
        return integralInfo;
    }

    public void setIntegralInfo(String integralInfo) {
        this.integralInfo = integralInfo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "BillIntegral{" +
                "integralId=" + integralId +
                ", integralUserId=" + integralUserId +
                ", integralInfo='" + integralInfo + '\'' +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", updateDate=" + updateDate +
                ", updateBy=" + updateBy +
                '}';
    }
}
