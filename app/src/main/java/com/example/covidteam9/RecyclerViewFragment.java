package com.example.covidteam9;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.covidteam9.dashboard.CovidCaseItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public class RecyclerViewFragment extends Fragment {

        private RecyclerView recyclerView;
        private ItemAdapter itemAdapter;

        public static RecyclerViewFragment newInstance() {
            return new RecyclerViewFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.recyclerview_container, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            CovidCaseItem.RetrofitInstance retrofitInstance = new CovidCaseItem.RetrofitInstance();
            retrofitInstance.getAPI()
                    .getCovidCases()
                    .enqueue(new Callback<ArrayList<CovidCaseItem>>() {
                        @Override
                        public void onResponse(Call<ArrayList<CovidCaseItem>> call,
                                               Response<ArrayList<CovidCaseItem>> response) {
                            recyclerView = view.findViewById(R.id.recyclerview);
                            if(!response.body().isEmpty()){
                                itemAdapter = new ItemAdapter(response.body());
                                recyclerView.setAdapter(itemAdapter);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        }

                        @Override
                        public void onFailure(Call<ArrayList<CovidCaseItem>> call, Throwable t) {
                            Log.d("hahaha", String.valueOf(t));
                        }
                    });
        }
}
