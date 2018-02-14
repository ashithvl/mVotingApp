package com.blueangels.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.blueangels.Adapter.CandidatesRecyclerAdapter;
import com.blueangels.Adapter.ElectionRecyclerAdapter;
import com.blueangels.DataService.DataService;
import com.blueangels.Model.CandidatesModel;
import com.blueangels.R;
import com.blueangels.Utils.EmptyRecyclerView;

import java.util.ArrayList;

public class CandidatesActivity extends AppCompatActivity {

    private Context mContext = CandidatesActivity.this;
    private EmptyRecyclerView candidatesRecyclerView;
    private ArrayList<CandidatesModel> candidatesArrayList;
    private TextView emptyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);

        candidatesRecyclerView = findViewById(R.id.candidatesRecyclerView);
        emptyTextView = findViewById(R.id.emptyView);
        candidatesArrayList = new ArrayList<>();

        candidatesArrayList = DataService.getInstance().getElectionCandiatesNameList();

        CandidatesRecyclerAdapter candidatesRecyclerAdapter = new CandidatesRecyclerAdapter(candidatesArrayList,mContext);
        candidatesRecyclerView.setHasFixedSize(true);
        candidatesRecyclerView.setEmptyView(emptyTextView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        candidatesRecyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        candidatesRecyclerView.setLayoutManager(linearLayoutManager);
        candidatesRecyclerView.setAdapter(candidatesRecyclerAdapter);
    }
}
