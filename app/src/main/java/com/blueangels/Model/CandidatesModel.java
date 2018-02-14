package com.blueangels.Model;

/**
 * Created by Leon on 14-02-18.
 */

public class CandidatesModel {

    private String imgUrl;
    private String name;
    private String totalCount;
    private String voted;

    public CandidatesModel(String imgUrl, String name, String totalCount, String voted) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.totalCount = totalCount;
        this.voted = voted;
    }

    public String getImgUrl() {

        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }
}
