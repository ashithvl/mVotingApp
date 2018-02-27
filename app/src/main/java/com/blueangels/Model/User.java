package com.blueangels.Model;

/**
 * Created by Leon on 27-02-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("cardnum")
    @Expose
    private String cardnum;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("userImage")
    @Expose
    private String userImage;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("isAdmin")
    @Expose
    private Integer isAdmin;
    @SerializedName("isQualified")
    @Expose
    private Integer isQualified;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createTs")
    @Expose
    private String createTs;
    @SerializedName("modifiedBy")
    @Expose
    private String modifiedBy;
    @SerializedName("modifiedTs")
    @Expose
    private String modifiedTs;
    @SerializedName("deleteFlag")
    @Expose
    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreateTs() {
        return createTs;
    }

    public void setCreateTs(String createTs) {
        this.createTs = createTs;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedTs() {
        return modifiedTs;
    }

    public void setModifiedTs(String modifiedTs) {
        this.modifiedTs = modifiedTs;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
