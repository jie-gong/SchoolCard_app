package com.example.school_card.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/13/下午 09:09
 */
public class Allgg_Bean {

    @SerializedName("studentid")
    private Object studentid;
    @SerializedName("id")
    private int id;
    @SerializedName("gz")
    private String gz;
    @SerializedName("deleted")
    private int deleted;
    @SerializedName("createTime")
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
