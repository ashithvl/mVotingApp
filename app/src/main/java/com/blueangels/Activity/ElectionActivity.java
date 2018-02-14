package com.blueangels.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.blueangels.Adapter.ElectionRecyclerAdapter;
import com.blueangels.DataService.DataService;
import com.blueangels.Model.ElectionModel;
import com.blueangels.R;
import com.blueangels.Utils.EmptyRecyclerView;

import java.util.ArrayList;

/**
 * Created by Leon on 09-02-18.
 */

public class ElectionActivity extends AppCompatActivity {

    private Context mContext = ElectionActivity.this;
    private EmptyRecyclerView electionRecyclerView;
    private ArrayList<ElectionModel> electionArrayList;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);

        electionRecyclerView = findViewById(R.id.electionRecyclerView);
        emptyTextView = findViewById(R.id.emptyView);
        electionArrayList = new ArrayList<>();

        electionArrayList = DataService.getInstance().getElectionNamesList();

        ElectionRecyclerAdapter electionRecyclerAdapter = new ElectionRecyclerAdapter(electionArrayList,mContext);
        electionRecyclerView.setHasFixedSize(true);
        electionRecyclerView.setEmptyView(emptyTextView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        electionRecyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        electionRecyclerView.setLayoutManager(linearLayoutManager);
        electionRecyclerView.setAdapter(electionRecyclerAdapter);

    }
}
