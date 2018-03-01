package com.blueangels.Model;

/**
 * Created by Leon on 01-03-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Election {

    @SerializedName("electionId")
    @Expose
    private Integer electionId;
    @SerializedName("electionName")
    @Expose
    private String electionName;
    @SerializedName("electionStartDate")
    @Expose
    private String electionStartDate;
    @SerializedName("electionEndDate")
    @Expose
    private String electionEndDate;

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getElectionStartDate() {
        return electionStartDate;
    }

    public void setElectionStartDate(String electionStartDate) {
        this.electionStartDate = electionStartDate;
    }

    public String getElectionEndDate() {
        return electionEndDate;
    }

    public void setElectionEndDate(String electionEndDate) {
        this.electionEndDate = electionEndDate;
    }

}



