package com.blueangels.Model;

/**
 * Created by Leon on 14-02-18.
 */

public class ElectionModel {
    private String electionName;
    private String electionTime;

    public ElectionModel(String electionName, String electionTime) {
        this.electionName = electionName;
        this.electionTime = electionTime;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getElectionTime() {
        return electionTime;
    }

    public void setElectionTime(String electionTime) {
        this.electionTime = electionTime;
    }
}
