package com.blueangels.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blueangels.Activity.CandidatesActivity;
import com.blueangels.Model.Election;
import com.blueangels.R;
import com.github.thunder413.datetimeutils.DateTimeStyle;
import com.github.thunder413.datetimeutils.DateTimeUtils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Leon on 14-02-18.
 */

public class ElectionRecyclerAdapter extends RecyclerView.Adapter<ElectionRecyclerAdapter.ElectionViewHolder> {

    private ArrayList<Election> electionArrayList;
    private Context mContext;
    private boolean current;

    public ElectionRecyclerAdapter(ArrayList<Election> electionArrayList, Context mContext, boolean current) {
        this.electionArrayList = electionArrayList;
        this.mContext = mContext;
        this.current = current;
    }

    @Override
    public ElectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ElectionViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.card_elections, parent, false));
    }

    @Override
    public void onBindViewHolder(final ElectionViewHolder holder, int position) {

        final Election electionModel = electionArrayList.get(position);

        Date date = DateTimeUtils.formatDate(electionModel.getElectionEndDate());

        holder.electionNameTextView.setText(electionModel.getElectionName());
        holder.electionTimeTextView.setText("Ends in: " + DateTimeUtils.formatWithStyle(date, DateTimeStyle.FULL));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent electionIntent = new Intent(mContext, CandidatesActivity.class);
                electionIntent.putExtra("id", electionModel.getElectionId());
                if (current)
                    electionIntent.putExtra("current", true);
                else
                    electionIntent.putExtra("current", false);
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
