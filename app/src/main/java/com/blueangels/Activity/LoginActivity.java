package com.blueangels.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.blueangels.Api.ApiFactory;
import com.blueangels.Api.ApiService;
import com.blueangels.MVoteApplication;
import com.blueangels.Model.User;
import com.blueangels.R;
import com.blueangels.Utils.PreferencesAppHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    private Context mContext = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void openRegister(View view) {
        startActivity(new Intent(mContext, RegisterActivity.class));
    }

    public void openMainActivity(View view) {
        if (username.getText().toString().length() <= 0 || password.getText().toString().length() <= 0) {
            Toasty.error(mContext, "In-Valid User Name or Password").show();
        } else {
            ApiService apiService = ApiFactory.create(MVoteApplication.get(LoginActivity.this).getRetrofit());
            User newUser = new User();
            newUser.setUsername(username.getText().toString());
            newUser.setPassword(password.getText().toString());
            Call<User> loginCall = apiService.login(newUser);
            loginCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    PreferencesAppHelper.setUserId(String.valueOf(response.body().getId()));
                    Toasty.success(mContext, "Login Successful!").show();
                    startActivity(new Intent(mContext, MainActivity.class));
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toasty.error(mContext, "In-Valid User Name or Password").show();
                }
            });
        }

//        startActivity(new Intent(mContext, MainActivity.class));
    }
}
