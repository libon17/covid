package com.example.covidteam9.Login;

import com.google.gson.annotations.SerializedName;

public class LoginAPIResponse{

    @SerializedName("data")
    private Data data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("token")
    private String token;

    public void setData(Data data){
        this.data = data;
    }

    public Data getData(){
        return data;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean isStatus(){
        return status;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    @Override
     public String toString(){
        return 
            "LoginAPIResponse{" + 
            "data = '" + data + '\'' + 
            ",message = '" + message + '\'' + 
            ",status = '" + status + '\'' + 
            ",token = '" + token + '\'' + 
            "}";
        }
}