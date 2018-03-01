package com.blueangels.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.blueangels.MVoteApplication;

/**
 * Created by Leon on 02-01-18.
 */

public class PreferencesAppHelper {

    public static final String ID = "id";

    private static final String PREFS_NAME = "mVote_App_Info";
    private static SharedPreferences mSharedPreferences = null;

    public static String getUserId() {
        return getSharedPreference().getString(ID, null);
    }

    public static void setUserId(String userId) {
        setDataInPrefs(ID, userId);
    }


    private static void setDataInPrefs(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static SharedPreferences getSharedPreference() {
        if (mSharedPreferences == null) {
            mSharedPreferences = MVoteApplication.getAppContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }

        return mSharedPreferences;
    }
}