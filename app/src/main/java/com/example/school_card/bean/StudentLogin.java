package com.example.school_card.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/13/下午 07:29
 */
public class StudentLogin {

    @SerializedName("studentid")
    private int studentid;
    @SerializedName("password")
    private String password;
    @SerializedName("kay")
    private String kay;
    @SerializedName("deleted")
    private int deleted;
    @SerializedName("createTime")
    private Object createTime;
    @SerializedName("updateTime")
    private Object updateTime;
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKay() {
        return kay;
    }

    public void setKay(String kay) {
        this.kay = kay;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
