package com.example.covidteam9;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.covidteam9.Login.LoginSession;
import com.example.covidteam9.databinding.ActivityProfileBinding;

import androidx.annotation.Nullable;

//import com.example.covidteam9.MainActivity;

public class ProfileActivity extends DrawerBaseActivity {
    public static final String TAG = "MainActivity";
    ActivityProfileBinding activityProfileBinding;
    TextView name_tv, email_tv;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        activityProfileBinding = activityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");

        name_tv = findViewById(R.id.tv_name);
        email_tv = findViewById(R.id.tv_email);

        String[] userData = LoginSession.getInstance().getUserDetail(ProfileActivity.this);
        Log.e(TAG,"user data :");
        name_tv.setText(userData[0]);
        email_tv.setText(userData[1]);
    }

}
