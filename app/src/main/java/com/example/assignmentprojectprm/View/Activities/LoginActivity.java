package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.LoginObj;
import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView userEmail, userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = findViewById(R.id.LoginEmail);
        userPassword = findViewById(R.id.LoginPassword);
    }

    public void signin(View view) {
        String loginEmail = userEmail.getText().toString();
        String loginPassword = userPassword.getText().toString();
        LoginObj loginObj = new LoginObj();
        loginObj.setUserName(loginEmail);
        loginObj.setPassword(loginPassword);
        ApiService.apiService.login(loginObj).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userLogin = response.body();
                Toast.makeText(LoginActivity.this, "Login Success " + userLogin.getCustomerFullName(), Toast.LENGTH_SHORT).show();
                userEmail.setText(userLogin.getCustomerFullName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, RegisActivity.class));
    }

    //startActivity(new Intent(RegisActivity.this, MainActivity.class));



}