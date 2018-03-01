package com.blueangels;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.blueangels.Utils.ErrorInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Leon on 27-02-18.
 */

public class MVoteApplication extends Application {

    public static final String BASE_URL = "http://192.168.0.103:8080/";
    private static Context context;
    private Retrofit retrofit;

    public static MVoteApplication get(Activity activity) {
        return (MVoteApplication) activity.getApplication();
    }

    public static Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        Cache cache = getCache(new File(context.getCacheDir(), "cache_mVote"));

        OkHttpClient okHttpClient = getOkHttpClient(cache);

        retrofit = getRetrofit(okHttpClient);

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Cache getCache(File fileCache) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(fileCache, cacheSize);//10Mb cache
    }

    private OkHttpClient getOkHttpClient(Cache cache) {
        return new OkHttpClient().newBuilder()
                .addInterceptor(new ErrorInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
//                .cache(cache)
                .build();
    }
}
