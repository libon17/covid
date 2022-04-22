package com.example.covidteam9.dashboard;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {
    public static final String  BASE_URL = "https://corona.lmao.ninja/v2/";

    @GET("countries")
    Call<ArrayList<CovidCaseItem>> getCovidCases();
}
