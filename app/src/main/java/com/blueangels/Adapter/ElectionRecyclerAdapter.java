package com.blueangels.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blueangels.Activity.CandidatesActivity;
import com.blueangels.Model.ElectionModel;
import com.blueangels.R;

import java.util.ArrayList;

/**
 * Created by Leon on 14-02-18.
 */

public class ElectionRecyclerAdapter extends RecyclerView.Adapter<ElectionRecyclerAdapter.ElectionViewHolder> {

    private ArrayList<ElectionModel> electionArrayList;
    private Context mContext;

    public ElectionRecyclerAdapter(ArrayList<ElectionModel> electionArrayList, Context mContext) {
        this.electionArrayList = electionArrayList;
        this.mContext = mContext;
    }

    @Override
    public ElectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ElectionViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.card_elections, parent, false));
    }

    @Override
    public void onBindViewHolder(final ElectionViewHolder holder, int position) {

        ElectionModel electionModel = electionArrayList.get(position);

        holder.electionNameTextView.setText(electionModel.getElectionName());
        holder.electionTimeTextView.setText("Ends in: "+electionModel.getElectionTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent electionIntent = new Intent(mContext,CandidatesActivity.class);
                mContext.startActivity(electionIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return electionArrayList.size();
    }

    class ElectionViewHolder extends RecyclerView.ViewHolder {

        private TextView electionNameTextView;
        private TextView electionTimeTextView;

        ElectionViewHolder(View itemView) {
            super(itemView);
            electionNameTextView = itemView.findViewById(R.id.election);
            electionTimeTextView = itemView.findViewById(R.id.electionTime);
        }
    }
}
