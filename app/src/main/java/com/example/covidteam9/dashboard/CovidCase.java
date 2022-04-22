package com.example.covidteam9.dashboard;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CovidCase {
    @SerializedName("CovidCase")
    private ArrayList<CovidCaseItem> covidCase;

    public ArrayList<CovidCaseItem> getCovidCase(){
        return covidCase;
    }
}
