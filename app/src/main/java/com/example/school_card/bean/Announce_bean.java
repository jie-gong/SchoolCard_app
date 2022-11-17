package com.example.school_card.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/14/下午 03:32
 */
public class Announce_bean implements Serializable {

    @SerializedName("studentid")
    private Object studentid;
    @SerializedName("id")
    private int id;
    @SerializedName("state")
    private int state;
    @SerializedName("gz")
    private String gz;
    @SerializedName("deleted")
    private int deleted;
    @SerializedName("createTime")
    private Date createTime;

    public Object getStudentid() {
        return studentid;
    }

    public void setStudentid(Object studentid) {
        this.studentid = studentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getGz() {
        return gz;
    }

    public void setGz(String gz) {
        this.gz = gz;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
