package com.blueangels.Model;

/**
 * Created by Leon on 01-03-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CandidateDetail {

    @SerializedName("votesCount")
    @Expose
    private Integer votesCount;
    @SerializedName("electionId")
    @Expose
    private Integer electionId;
    @SerializedName("candidateId")
    @Expose
    private Integer candidateId;
    @SerializedName("candidatesName")
    @Expose
    private String candidatesName;
    @SerializedName("candidatesImage")
    @Expose
    private String candidatesImage;
    @SerializedName("vote")
    @Expose
    private String vote;

    public Integer getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidatesName() {
        return candidatesName;
    }

    public void setCandidatesName(String candidatesName) {
        this.candidatesName = candidatesName;
    }

    public String getCandidatesImage() {
        return candidatesImage;
    }

    public void setCandidatesImage(String candidatesImage) {
        this.candidatesImage = candidatesImage;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

}