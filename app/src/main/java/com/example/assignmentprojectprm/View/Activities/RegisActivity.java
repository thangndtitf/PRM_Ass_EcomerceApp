package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisActivity extends AppCompatActivity {

    EditText name, email, password;
    Button regisBtn;
    User regisUser;
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        name = findViewById(R.id.RegisName);
        email = findViewById(R.id.RegisEmail);
        password = findViewById(R.id.RegisPassword);
        regisBtn = findViewById(R.id.regisBtn);
        regisUser = new User();
        gson = new Gson();

    }


    public void RegisSignUp(View view){
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Enter Name!", Toast.LENGTH_SHORT).show();
//            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show();
//            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
//            return;
        }
        else if(password.getText().toString().length() < 6){
            Toast.makeText(this, "Password too short , enter minimum 6 character ", Toast.LENGTH_SHORT).show();
//            return;
        }else {
//            startActivity(new Intent(RegisActivity.this, MainActivity.class));
            regisUser.setUserName(userName);
            regisUser.setUserEmail(userEmail);
            regisUser.setUserPassword(userPassword);

            ApiService.apiService.getInfoUser(Integer.parseInt(userName)).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(RegisActivity.this, "Call API success", Toast.LENGTH_SHORT).show();
                    User user = response.body();
                    if(user != null){
                        name.setText((user.getCustomerFullName()));
                        Toast.makeText(RegisActivity.this, "Call API success2 ", Toast.LENGTH_SHORT).show();

                        System.out.println(user.getCustomerFullName());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(RegisActivity.this, "Call API Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

        public void RegisSignIn(View view){
            startActivity(new Intent(RegisActivity.this, LoginActivity.class));

        }

}