package com.blueangels.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blueangels.R;

public class LoginActivity extends AppCompatActivity {

    private Context mContext = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openRegister(View view) {
        startActivity(new Intent(mContext, RegisterActivity.class));
    }

    public void openMainActivity(View view) {
        startActivity(new Intent(mContext,MainActivity.class));
    }
}
