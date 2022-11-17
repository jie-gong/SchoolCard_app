package com.example.school_card.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/13/下午 09:29
 */
public class Banner_Bean {

    @SerializedName("id")
    private int id;
    @SerializedName("sort")
    private int sort;
    @SerializedName("advTitle")
    private String advTitle;
    @SerializedName("advImg")
    private String advImg;
    @SerializedName("servModule")
    private String servModule;
    @SerializedName("targetId")
    private int targetId;
    @SerializedName("type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public String getServModule() {
        return servModule;
    }

    public void setServModule(String servModule) {
        this.servModule = servModule;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
