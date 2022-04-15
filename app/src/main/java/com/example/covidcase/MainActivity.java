package com.example.covidcase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covidcase.Model.CovidCaseItem;
import com.example.covidcase.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        show login if logged in show fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, RecyclerViewFragment.newInstance())
                    .commitNow();
        }
    }
//
//    @Override
//    public void onBackPressed() {
//        Fragment f = getSupportFragmentManager().findFragmentById(R.id.activity_main);
//        if (f instanceof RecyclerViewFragment)
//            super.onBackPressed();
//        else{
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container_every_day, Day4MainFragment.newInstance())
//                    .commitNow();
//        }
//    }
//    private ArrayList<CovidCaseItem> items;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        RetrofitInstance retrofitInstance = new RetrofitInstance();
//        retrofitInstance.getAPI().getCovidCases().enqueue(new Callback<List<CovidCaseItem>>() {
//            @Override
//            public void onResponse(Call<List<CovidCaseItem>> call, Response<List<CovidCaseItem>> response) {
//                items = (ArrayList<CovidCaseItem>) response.body();
//                for (CovidCaseItem item : items){
//                    Log.d("hahaha", item.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CovidCaseItem>> call, Throwable t) {
//                Log.d("hahaha", String.valueOf(t));
//            }
//        });
//    }

//    @Nullable
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_main, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view.findViewById(R.id.recyclerview);
//        itemAdapter = new ItemAdapter(items);
//        recyclerView.setAdapter(itemAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//    }
}