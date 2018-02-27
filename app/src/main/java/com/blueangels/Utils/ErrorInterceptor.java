package com.blueangels.Utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by Leon on 26-12-17.
 */

public class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            Timber.e(String.valueOf(response.code()));
            Timber.e(String.valueOf(response.headers()));
            Timber.e(String.valueOf(response.networkResponse()));
            Timber.e(String.valueOf(response.message()));
        }
        return response;
    }
}
