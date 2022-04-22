package com.example.covidteam9.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class LoginSession {
    public static final String TAG = "MainActivity";
    public static final String SESSION_PREFERENCE = "com.example.covidteam9.Login.SESSION_PREFERENCE";
    public static final String SESSION_TOKEN = "com.example.covidteam9.Login.SESSION_TOKEN";
    public static final String SESSION_EXPIRE_TIME = "com.example.covidteam9.Login.SESSION_EXPIRE_TIME";
    public static final String SESSION_NAME = "com.example.covidteam9.Login.SESSION_NAME";
    public static final String SESSION_EMAIL = "com.example.covidteam9.Login.SESSION_EMAIL";
//    public static final String SESSION_PICT = "com.example.sessionmanagement.SESSION_PICT";

    private static LoginSession INSTANCE;

    public static LoginSession getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LoginSession(); }
        return INSTANCE;
    }

    public void startUserSession(Context context, int expiredInstance, String token, String name, String email) {
        Calendar calendar = Calendar.getInstance();
        Date userLoggedTime = calendar.getTime();
        calendar.setTime(userLoggedTime);
        calendar.add(Calendar.SECOND, expiredInstance);
        Date expiryTime = calendar.getTime();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(SESSION_EXPIRE_TIME, expiryTime.getTime());
        editor.putString(SESSION_TOKEN, token);
        editor.putString(SESSION_NAME, name);
        editor.putString(SESSION_EMAIL, email);
        editor.apply();
    }

    public boolean isSessionActive(Context context, Date currentTime) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE);
        Date sessionExpireAt = new Date(context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE).getLong(SESSION_EXPIRE_TIME, 0));
        Log.e(TAG, "Session Token : " + sharedPrefs.getString(SESSION_TOKEN, "Token kosong"));
        Log.e(TAG, "Session Preference : " + sharedPrefs.getString(SESSION_PREFERENCE, "PREF kosong"));
        return  !currentTime.after(sessionExpireAt);
    }


    public void endUserSession(Context context){
        SharedPreferences sharedPrefs = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.apply();
    }

    public String[] getUserDetail(Context context){
        String[] userData = new String[2];
        SharedPreferences sharedPrefs = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE);
        userData[0] = sharedPrefs.getString(SESSION_NAME, "No Name");
        userData[1] = sharedPrefs.getString(SESSION_EMAIL, "No Enmail");
        return userData;
    }
}
