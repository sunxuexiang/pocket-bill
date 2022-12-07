package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @Description : TODO
 * @author: Hulk
 * @date : 0420:51
 */
@TableName(value = "bill_rout")
public class BillRout {

    private Integer routId;
    private Integer routType;
    private Integer routValue;
    private Date createDate;
    private Integer createBy;
    private Date updateDate;
    private Integer updateBy;

    public Integer getRoutId() {
        return routId;
    }

    public void setRoutId(Integer routId) {
        this.routId = routId;
    }

    public Integer getRoutType() {
        return routType;
    }

    public void setRoutType(Integer routType) {
        this.routType = routType;
    }

    public Integer getRoutValue() {
        return routValue;
    }

    public void setRoutValue(Integer routValue) {
        this.routValue = routValue;
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
