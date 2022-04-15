package com.example.covidcase.Model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CovidCase{

	@SerializedName("CovidCase")
	private ArrayList<CovidCaseItem> covidCase;

	public ArrayList<CovidCaseItem> getCovidCase(){
		return covidCase;
	}
}