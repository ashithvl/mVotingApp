package com.blueangels;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Leon on 09-02-18.
 */

public class RegisterActivity extends AppCompatActivity {

    private Context mContext = RegisterActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void openLoginActivity(View view) {
        startActivity(new Intent(mContext,LoginActivity.class));
    }
}
