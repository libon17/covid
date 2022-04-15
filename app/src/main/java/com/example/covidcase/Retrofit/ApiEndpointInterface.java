package com.example.covidcase.Retrofit;

import com.example.covidcase.Model.CovidCase;
import com.example.covidcase.Model.CovidCaseItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {
    public static final String  BASE_URL = "https://corona.lmao.ninja/v2/";

    @GET("countries")
    Call<ArrayList<CovidCaseItem>> getCovidCases();
}
