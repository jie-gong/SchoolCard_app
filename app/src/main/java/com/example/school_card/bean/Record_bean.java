package com.example.school_card.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/17/下午 12:50
 */
public class Record_bean implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("studentid")
    private int studentid;
    @SerializedName("id")
    private int id;
    @SerializedName("balance")
    private String balance;
    @SerializedName("createTime")
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
