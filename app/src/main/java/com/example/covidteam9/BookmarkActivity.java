package com.example.covidteam9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.covidteam9.databinding.ActivityBookmarkBinding;
import com.example.covidteam9.databinding.ActivityDashboardBinding;

public class BookmarkActivity extends DrawerBaseActivity {

    ActivityBookmarkBinding activityBookmarkBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        activityBookmarkBinding = ActivityBookmarkBinding.inflate(getLayoutInflater());
        setContentView(activityBookmarkBinding.getRoot());
        allocateActivityTitle("Bookmark");
    }
}