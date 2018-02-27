package com.blueangels.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.blueangels.Api.ApiFactory;
import com.blueangels.Api.ApiService;
import com.blueangels.MVoteApplication;
import com.blueangels.Model.User;
import com.blueangels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Leon on 09-02-18.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.aadharNum)
    EditText aadharNum;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText rePassword;
    private Context mContext = RegisterActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    public void openLoginActivity(View view) {
        if (password.getText().toString().equals(rePassword.getText().toString())) {
            ApiService apiService = ApiFactory.create(MVoteApplication.get(RegisterActivity.this).getRetrofit());
            User newUser = new User();
            newUser.setCardnum(aadharNum.getText().toString());
            newUser.setPassword(password.getText().toString());
            Call<User> userCall = apiService.register(newUser);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toasty.success(mContext,"Registration Successful!").show();
                    startActivity(new Intent(mContext, LoginActivity.class));
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toasty.error(mContext,"In-Valid Aadhaar Card Number").show();
                }
            });
        }else {
            Toasty.warning(mContext,"Password and Confirm Password are different").show();
        }
    }
}
