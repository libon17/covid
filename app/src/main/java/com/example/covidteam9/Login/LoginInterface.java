package com.example.covidteam9.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginInterface {
    @FormUrlEncoded
    @POST("/api/user/login")
    @Headers({"X-API-KEY: 454041184B0240FBA3AACD15A1F7A8BB"})
    Call<LoginAPIResponse> getUserInformation(@Field("username") String username, @Field("password") String password);
}
