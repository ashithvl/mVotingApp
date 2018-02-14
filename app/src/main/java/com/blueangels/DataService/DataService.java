package com.blueangels.DataService;

import com.blueangels.Model.CandidatesModel;
import com.blueangels.Model.ElectionModel;

import java.util.ArrayList;

/**
 * Created by Leon on 14-02-18.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    private DataService() {
    }

    public static DataService getInstance() {
        return ourInstance;
    }

    public ArrayList<ElectionModel> getElectionNamesList() {
        ArrayList<ElectionModel> models = new ArrayList<>();
        models.add(new ElectionModel("Election 1", "24:00:00 hrs"));
        models.add(new ElectionModel("Election 2", "26:00:00 hrs"));
        models.add(new ElectionModel("Election 3", "27:00:00 hrs"));
        models.add(new ElectionModel("Election 4", "28:00:00 hrs"));
        models.add(new ElectionModel("Election 5", "29:00:00 hrs"));
        models.add(new ElectionModel("Election 6", "31:00:00 hrs"));

        return models;
    }

    public ArrayList<CandidatesModel> getElectionCandiatesNameList() {

        ArrayList<CandidatesModel> candidatesModels = new ArrayList<>();

        candidatesModels.add(new CandidatesModel("img", "candidate 1", "20", "1"));
        candidatesModels.add(new CandidatesModel("img", "candidate 2", "2", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 3", "4", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 4", "1", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 5", "0", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 6", "8", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 7", "12", "0"));
        candidatesModels.add(new CandidatesModel("img", "candidate 8", "16", "0"));

        return candidatesModels;
    }
}
