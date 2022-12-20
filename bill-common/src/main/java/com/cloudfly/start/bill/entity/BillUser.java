package com.cloudfly.start.bill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bill_user")
public class BillUser {

    @TableId(value = "user_id",type= IdType.AUTO)
    private Integer userId;
    private String userOpenid;
    private String userName;
    private String userImg;
    private String userSex;
    private Integer userIntegral;
    private Integer userInvitation;
    private Date createDate;
    private int createBy;
    private Date updateDate;
    private int updateBy;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Integer getUserInvitation() {
        return userInvitation;
    }

    public void setUserInvitation(Integer userInvitation) {
        this.userInvitation = userInvitation;
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

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    @Override
    public String toString() {
        return "BillUser{" +
                "userId=" + userId +
                ", userOpenid='" + userOpenid + '\'' +
                ", userName='" + userName + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userIntegral=" + userIntegral +
                ", userInvitation=" + userInvitation +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", updateDate=" + updateDate +
                ", updateBy=" + updateBy +
                '}';
    }
}
