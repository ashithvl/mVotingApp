package com.blueangels.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.TextView;

import com.blueangels.Adapter.CandidatesRecyclerAdapter;
import com.blueangels.Adapter.ElectionRecyclerAdapter;
import com.blueangels.Api.ApiFactory;
import com.blueangels.Api.ApiService;
import com.blueangels.DataService.DataService;
import com.blueangels.MVoteApplication;
import com.blueangels.Model.Candidate;
import com.blueangels.Model.CandidatesModel;
import com.blueangels.Model.Election;
import com.blueangels.R;
import com.blueangels.Utils.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidatesActivity extends AppCompatActivity {

    private Context mContext = CandidatesActivity.this;
    private EmptyRecyclerView candidatesRecyclerView;
    private ArrayList<Candidate> candidatesArrayList;
    private TextView emptyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);

        candidatesRecyclerView = findViewById(R.id.candidatesRecyclerView);
        emptyTextView = findViewById(R.id.emptyView);
        candidatesArrayList = new ArrayList<>();

//        candidatesArrayList = DataService.getInstance().getElectionCandiatesNameList();

        ApiService apiService = ApiFactory.create(MVoteApplication.get(CandidatesActivity.this).getRetrofit());
        Call<List<Candidate>> call = apiService.getCandidatesList(String.valueOf(getIntent().getIntExtra("id", 0)));
        call.enqueue(new Callback<List<Candidate>>() {
            @Override
            public void onResponse(Call<List<Candidate>> call, Response<List<Candidate>> response) {
                if (response.body() != null) {
                    candidatesArrayList = (ArrayList<Candidate>) response.body();
                    CandidatesRecyclerAdapter candidatesRecyclerAdapter = new CandidatesRecyclerAdapter(candidatesArrayList,
                            mContext, String.valueOf(getIntent().getIntExtra("id", 0))
                            , getIntent().getBooleanExtra("current", false));
                    candidatesRecyclerView.setHasFixedSize(true);
                    candidatesRecyclerView.setEmptyView(emptyTextView);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                    candidatesRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                    candidatesRecyclerView.setLayoutManager(linearLayoutManager);
                    candidatesRecyclerView.setAdapter(candidatesRecyclerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Candidate>> call, Throwable t) {
                Toasty.warning(CandidatesActivity.this, "OOPS! Something went Wrong").show();
            }
        });

    }
}
