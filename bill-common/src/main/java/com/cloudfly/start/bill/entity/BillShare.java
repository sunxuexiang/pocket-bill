package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bill_share")
public class BillShare {

    private Integer shareId;
    private Integer shareBookId;
    private Integer shareUserId;
    private Integer sharePower;
    private Date createDate;
    private int createBy;
    private Date updateDate;
    private int updateBy;

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getShareBookId() {
        return shareBookId;
    }

    public void setShareBookId(Integer shareBookId) {
        this.shareBookId = shareBookId;
    }

    public Integer getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Integer shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Integer getSharePower() {
        return sharePower;
    }

    public void setSharePower(Integer sharePower) {
        this.sharePower = sharePower;
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





}
