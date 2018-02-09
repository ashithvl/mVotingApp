package com.blueangels;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openElectionsActivity(View view) {
        Intent electionIntent = new Intent(mContext,ElectionActivity.class);
        electionIntent.putExtra("current",true);
        electionIntent.putExtra("previous",false);
        startActivity(electionIntent);

    }

    public void openPreviousElectionsActivity(View view) {
        Intent electionIntent = new Intent(mContext,ElectionActivity.class);
        electionIntent.putExtra("current",false);
        electionIntent.putExtra("previous",true);
        startActivity(electionIntent);
    }
}
