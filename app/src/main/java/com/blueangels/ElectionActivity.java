package com.blueangels;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Leon on 09-02-18.
 */

public class ElectionActivity extends AppCompatActivity{

    private Context mContext = ElectionActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);
    }
}
