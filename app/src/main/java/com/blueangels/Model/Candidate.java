package com.blueangels.Model;

/**
 * Created by Leon on 01-03-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Candidate {

    @SerializedName("electionId")
    @Expose
    private Integer electionId;
    @SerializedName("candidatesId")
    @Expose
    private Integer candidatesId;
    @SerializedName("candidatesName")
    @Expose
    private String candidatesName;

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Integer getCandidatesId() {
        return candidatesId;
    }

    public void setCandidatesId(Integer candidatesId) {
        this.candidatesId = candidatesId;
    }

    public String getCandidatesName() {
        return candidatesName;
    }

    public void setCandidatesName(String candidatesName) {
        this.candidatesName = candidatesName;
    }

}



