package com.blueangels.Api;

import retrofit2.Retrofit;

/**
 * Created by Leon on 19-12-17.
 */

public class ApiFactory {

    public static ApiService create(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
