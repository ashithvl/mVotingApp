package com.blueangels.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blueangels.Activity.CandidatesActivity;
import com.blueangels.Model.CandidatesModel;
import com.blueangels.Model.ElectionModel;
import com.blueangels.R;

import java.util.ArrayList;

/**
 * Created by Leon on 14-02-18.
 */

public class CandidatesRecyclerAdapter extends RecyclerView.Adapter<CandidatesRecyclerAdapter.ElectionViewHolder> {

    private ArrayList<CandidatesModel> candidatesArrayList;
    private Context mContext;

    public CandidatesRecyclerAdapter(ArrayList<CandidatesModel> electionArrayList, Context mContext) {
        this.candidatesArrayList = electionArrayList;
        this.mContext = mContext;
    }

    @Override
    public ElectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ElectionViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.card_candidates, parent, false));
    }

    @Override
    public void onBindViewHolder(final ElectionViewHolder holder, int position) {

        CandidatesModel candidatesModel = candidatesArrayList.get(position);

        holder.candidateNameTextView.setText(candidatesModel.getName());
        holder.countTimeTextView.setText("Total Vote Count: " + candidatesModel.getTotalCount());
        if (candidatesModel.getVoted().equals("1")) {
            holder.voteButton.setText("Voted");
            holder.voteButton.setEnabled(false);
            holder.voteButton.setBackground(ContextCompat.getDrawable(mContext, R.drawable.vote_btn_style));
        } else {
            holder.voteButton.setText("Vote");
            holder.voteButton.setBackground(ContextCompat.getDrawable(mContext, R.drawable.vote_btn_style_red));
        }

        holder.voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean voted = false;
                for (CandidatesModel candidatesModel1 : candidatesArrayList) {
                    if (candidatesModel1.getVoted().equals("1")) {
                        voted = true;
                    }
                }
                if (voted) {
                    Toast.makeText(mContext, "Already voted", Toast.LENGTH_LONG).show();
                } else {

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return candidatesArrayList.size();
    }

    class ElectionViewHolder extends RecyclerView.ViewHolder {

        private TextView candidateNameTextView;
        private TextView countTimeTextView;
        private ImageView candidateImageView;
        private Button voteButton;

        ElectionViewHolder(View itemView) {
            super(itemView);
            candidateNameTextView = itemView.findViewById(R.id.name);
            countTimeTextView = itemView.findViewById(R.id.count);
            candidateImageView = itemView.findViewById(R.id.img);
            voteButton = itemView.findViewById(R.id.vote);
        }
    }
}
