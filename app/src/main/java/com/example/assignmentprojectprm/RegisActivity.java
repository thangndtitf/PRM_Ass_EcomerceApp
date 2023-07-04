package com.example.assignmentprojectprm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
    }

    public void signup(View view){
        startActivity(new Intent(RegisActivity.this, MainActivity.class));
    }

        public void signin(View view){
            startActivity(new Intent(RegisActivity.this, LoginActivity.class));

        }

}