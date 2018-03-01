package com.blueangels.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.blueangels.Adapter.ElectionRecyclerAdapter;
import com.blueangels.Api.ApiFactory;
import com.blueangels.Api.ApiService;
import com.blueangels.DataService.DataService;
import com.blueangels.MVoteApplication;
import com.blueangels.Model.Election;
import com.blueangels.Model.ElectionModel;
import com.blueangels.R;
import com.blueangels.Utils.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Leon on 09-02-18.
 */

public class ElectionActivity extends AppCompatActivity {

    private Context mContext = ElectionActivity.this;
    private EmptyRecyclerView electionRecyclerView;
    private ArrayList<Election> electionArrayList;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);

        electionRecyclerView = findViewById(R.id.electionRecyclerView);
        emptyTextView = findViewById(R.id.emptyView);
        electionArrayList = new ArrayList<>();

//        electionArrayList = DataService.getInstance().getElectionNamesList();

        ApiService apiService = ApiFactory.create(MVoteApplication.get(ElectionActivity.this).getRetrofit());
        final Bundle bundle = getIntent().getExtras();

        //current activity
        if (bundle != null && bundle.getBoolean("current")) {
            Call<List<Election>> call = apiService.getCurrentElections();
            call.enqueue(new Callback<List<Election>>() {
                @Override
                public void onResponse(Call<List<Election>> call, Response<List<Election>> response) {
                    if (response.body() != null) {
                        electionArrayList = (ArrayList<Election>) response.body();
                        ElectionRecyclerAdapter electionRecyclerAdapter = new ElectionRecyclerAdapter(electionArrayList,
                                mContext, bundle.getBoolean("current"));
                        electionRecyclerView.setHasFixedSize(true);
                        electionRecyclerView.setEmptyView(emptyTextView);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                        electionRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                        electionRecyclerView.setLayoutManager(linearLayoutManager);
                        electionRecyclerView.setAdapter(electionRecyclerAdapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Election>> call, Throwable t) {
                    Toasty.warning(ElectionActivity.this, "OOPS! Something went Wrong").show();
                }
            });
        } else {
            Call<List<Election>> call = apiService.getPreviousElections();
            call.enqueue(new Callback<List<Election>>() {
                @Override
                public void onResponse(Call<List<Election>> call, Response<List<Election>> response) {
                    if (response.body() != null) {
                        electionArrayList = (ArrayList<Election>) response.body();
                        ElectionRecyclerAdapter electionRecyclerAdapter = new ElectionRecyclerAdapter(electionArrayList
                                , mContext, bundle.getBoolean("current"));
                        electionRecyclerView.setHasFixedSize(true);
                        electionRecyclerView.setEmptyView(emptyTextView);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                        electionRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                        electionRecyclerView.setLayoutManager(linearLayoutManager);
                        electionRecyclerView.setAdapter(electionRecyclerAdapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Election>> call, Throwable t) {
                    Toasty.warning(ElectionActivity.this, "OOPS! Something went Wrong").show();
                }
            });
        }

    }
}
