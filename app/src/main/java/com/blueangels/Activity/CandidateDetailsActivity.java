package com.blueangels.Activity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueangels.Api.ApiFactory;
import com.blueangels.Api.ApiService;
import com.blueangels.MVoteApplication;
import com.blueangels.Model.CandidateDetail;
import com.blueangels.Model.Vote;
import com.blueangels.R;
import com.blueangels.Utils.PreferencesAppHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidateDetailsActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.vote)
    Button vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_details);
        ButterKnife.bind(this);

        final String electionId = getIntent().getStringExtra("e_id");
        final String candidateId = getIntent().getStringExtra("c_id");
        final String userId = PreferencesAppHelper.getUserId();

        Log.e("t", userId + electionId + candidateId);
        if (!getIntent().getBooleanExtra("current", false)) {
            vote.setEnabled(false);
        }

        final ApiService apiService = ApiFactory.create(MVoteApplication.get(CandidateDetailsActivity.this).getRetrofit());
        Call<CandidateDetail> call = apiService.getCandidateVote(userId, electionId, candidateId);
        call.enqueue(new Callback<CandidateDetail>() {
            @Override
            public void onResponse(Call<CandidateDetail> call, final Response<CandidateDetail> response) {
                CandidateDetail candidateDetail = response.body();
                if (response.code() != 404) {
                    name.setText(candidateDetail.getCandidatesName());
                    count.setText("Total Vote Count: " + candidateDetail.getVotesCount());
                    if (candidateDetail.getVote().equals("true")) {
                        vote.setText("Voted");
                        vote.setEnabled(false);
                        vote.setBackground(ContextCompat.getDrawable(CandidateDetailsActivity.this,
                                R.drawable.vote_btn_style));
                    } else {
                        vote.setText("Vote");
                        vote.setBackground(ContextCompat.getDrawable(CandidateDetailsActivity.this,
                                R.drawable.vote_btn_style_red));
                    }

                    vote.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("y", "onClick: " + response.body().getVote());
                            if (response.body().getVote().equals("true")) {
                                Toasty.info(CandidateDetailsActivity.this, "Already voted").show();
                            } else {
                                Call<Vote> voteStringCall = apiService.vote(userId, electionId, candidateId);
                                voteStringCall.enqueue(new Callback<Vote>() {
                                    @Override
                                    public void onResponse(Call<Vote> call, Response<Vote> response) {
                                        Log.e("t", "" + response.code());
                                        Vote vote = response.body();
                                        if (vote != null && vote.getVote().equals("success")) {
                                            Toasty.success(CandidateDetailsActivity.this, "Voted Successfully!!!").show();
                                        } else {
                                            Toasty.info(CandidateDetailsActivity.this, "Already voted").show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Vote> call, Throwable t) {
                                        Toasty.error(CandidateDetailsActivity.this,
                                                "Already voted in this election to another Candidate").show();
                                    }
                                });
                            }
                        }
                    });
                } else {
                    name.setText(getIntent().getStringExtra("name"));
                    count.setText("Total Vote Count: 0");
                    vote.setText("Vote");
                    vote.setBackground(ContextCompat.getDrawable(CandidateDetailsActivity.this,
                            R.drawable.vote_btn_style_red));

                    vote.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ApiService voteApiService = ApiFactory.create(MVoteApplication.get(CandidateDetailsActivity.this).getRetrofit());
                            Call<Vote> voteStringCall = voteApiService.vote(userId, electionId, candidateId);
                            voteStringCall.enqueue(new Callback<Vote>() {
                                @Override
                                public void onResponse(Call<Vote> call, Response<Vote> response) {
                                    Vote votes = response.body();
                                    if (votes != null && votes.getVote().equals("success")) {
                                        count.setText("Total Vote Count: 1");
                                        vote.setText("Voted");
                                        vote.setBackground(ContextCompat.getDrawable(CandidateDetailsActivity.this,
                                                R.drawable.vote_btn_style));
                                        Toasty.success(CandidateDetailsActivity.this, "Voted Successfully!!!").show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Vote> call, Throwable t) {
                                    Log.e("ttt", "onFailure: " + t.getMessage());
                                    Toasty.error(CandidateDetailsActivity.this,
                                            "Already voted in this election to another Candidate").show();
                                }
                            });

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<CandidateDetail> call, Throwable t) {
                Toasty.warning(CandidateDetailsActivity.this, "OOPS! Something went Wrong").show();
            }
        });


    }
}
