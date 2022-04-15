package com.example.covidcase.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CovidCase{

	@SerializedName("CovidCase")
	private List<CovidCaseItem> covidCase;

	public List<CovidCaseItem> getCovidCase(){
		return covidCase;
	}
}