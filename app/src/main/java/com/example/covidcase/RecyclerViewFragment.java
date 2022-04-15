package com.example.covidcase;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidcase.Model.CovidCaseItem;
import com.example.covidcase.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

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
        RetrofitInstance retrofitInstance = new RetrofitInstance();
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

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        SearchManager sm = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
//        SearchView sv = (SearchView) menu.findItem(R.id.search).getActionView();
//        sv.setSearchableInfo(sm.getSearchableInfo(getActivity().getComponentName()));
//        sv.setIconifiedByDefault(true);
//        sv.setMaxWidth(Integer.MAX_VALUE);
//        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                notifyList(s);
//                return true;
//            }
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)){
//                    resetData();
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

//    private void resetData(){
//        presidents.clear();
//        presidents.addAll(President.generateDateItem());
//        itemAdapter.notifyDataSetChanged();
//    }

//    private void notifyList(String query){
//        President president = doSearchItems(query);
//        if (president != null) {
//            presidents.clear();
//            presidents.add(president);
//            itemAdapter.notifyDataSetChanged();
//        }else{
//            Toast.makeText(getActivity().getApplicationContext(), "data tidak ditem" +
//                    "ukan", Toast.LENGTH_SHORT).show();
//        }
//    }

//    private President doSearchItems(String query){
//        President foundPresident = null;
//        for (President president : presidents) {
//            if (president.getName().equalsIgnoreCase(query)) {
//                foundPresident = president;
//                break;
//            }
//        }
//        return foundPresident;
//    }
}