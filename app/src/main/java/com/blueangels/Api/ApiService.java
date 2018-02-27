package com.blueangels.Api;

import com.blueangels.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Leon on 19-12-17.
 */

public interface ApiService {

    @POST("user/login")
    Call<User> login(@Body User user);

    @POST("user/register")
    Call<User> register(@Body User user);
}
