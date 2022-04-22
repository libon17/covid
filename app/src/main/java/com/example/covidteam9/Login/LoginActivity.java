package com.example.covidteam9.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidteam9.DashboardActivity;
//import com.example.covidteam9.MainActivity;
import com.example.covidteam9.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView usernametv, passtv;
    Button loginbtn;
    public static final String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernametv = findViewById(R.id.tv_User);
        passtv = findViewById(R.id.tv_Password);
        loginbtn = findViewById(R.id.btn_Login);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String username = usernametv.getText().toString();
        String password = passtv.getText().toString();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this, "Username or Password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!username.isEmpty() && !password.isEmpty()){
            LoginInterface loginInterface = LoginRetrofitClient.getRetrofitInstance().create(LoginInterface.class);
            Call<LoginAPIResponse> call = loginInterface.getUserInformation(username,password);
            call.enqueue(new Callback<LoginAPIResponse>() {
                @Override
                public void onResponse(Call<LoginAPIResponse> call, Response<LoginAPIResponse> response) {
                    Log.e(TAG, "onResponse name : " + response.code());
                    if ( response.code() == 200 ) {
                        if (response.body().isStatus()){
                            startAndStoreSession(response.body().getToken(),
                                    response.body().getData().getFullName(),response.body().getData().getEmail());
                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }}
                    if (response.code() != 200){
                        Toast.makeText(LoginActivity.this, "wrong username or password ", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<LoginAPIResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure : " + t.getMessage());
                }
            });
        }
        else{
            Toast.makeText(LoginActivity.this, "not matched", Toast.LENGTH_SHORT).show();
        }
    }

    private void startAndStoreSession(String authToken, String name, String email){
        LoginSession.getInstance().startUserSession(LoginActivity.this,3000, authToken, name, email);
    }
}
