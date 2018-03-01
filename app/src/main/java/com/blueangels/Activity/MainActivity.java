package com.blueangels.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blueangels.R;

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
        startActivity(electionIntent);

    }

    public void openPreviousElectionsActivity(View view) {
        Intent electionIntent = new Intent(mContext,ElectionActivity.class);
        electionIntent.putExtra("current",false);
        startActivity(electionIntent);
    }
}
