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

import com.blueangels.Activity.CandidateDetailsActivity;
import com.blueangels.Activity.CandidatesActivity;
import com.blueangels.Model.Candidate;
import com.blueangels.Model.CandidatesModel;
import com.blueangels.Model.ElectionModel;
import com.blueangels.R;

import java.util.ArrayList;

/**
 * Created by Leon on 14-02-18.
 */

public class CandidatesRecyclerAdapter extends RecyclerView.Adapter<CandidatesRecyclerAdapter.ElectionViewHolder> {

    private ArrayList<Candidate> candidatesArrayList;
    private Context mContext;
    private String elecionId;
    private boolean current;

    public CandidatesRecyclerAdapter(ArrayList<Candidate> electionArrayList, Context mContext, String elecionId, boolean current) {
        this.candidatesArrayList = electionArrayList;
        this.mContext = mContext;
        this.elecionId = elecionId;
        this.current = current;
    }

    @Override
    public ElectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ElectionViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.card_candidates, parent, false));
    }

    @Override
    public void onBindViewHolder(final ElectionViewHolder holder, final int position) {

        Candidate candidatesModel = candidatesArrayList.get(position);

        holder.candidateNameTextView.setText(candidatesModel.getCandidatesName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent candidateIntent = new Intent(mContext, CandidateDetailsActivity.class);
                candidateIntent.putExtra("c_id", String.valueOf(candidatesArrayList.get(position).getCandidatesId()));
                candidateIntent.putExtra("e_id", elecionId);
                candidateIntent.putExtra("name", candidatesArrayList.get(position).getCandidatesName());
                if (current)
                    candidateIntent.putExtra("current", true);
                else
                    candidateIntent.putExtra("current", false);
                mContext.startActivity(candidateIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return candidatesArrayList.size();
    }

    class ElectionViewHolder extends RecyclerView.ViewHolder {

        private TextView candidateNameTextView;
        private ImageView candidateImageView;

        ElectionViewHolder(View itemView) {
            super(itemView);
            candidateNameTextView = itemView.findViewById(R.id.name);
            candidateImageView = itemView.findViewById(R.id.img);
        }
    }
}
