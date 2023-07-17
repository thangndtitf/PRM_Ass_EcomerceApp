package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAddressActivity extends AppCompatActivity {

    EditText name, address, city, postalCode, phoneNumber;
    Toolbar toolbar;
    Button addAddressBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = findViewById(R.id.add_address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name = findViewById(R.id.ad_name);
        address = findViewById(R.id.ad_address);
        city = findViewById(R.id.ad_city);
        postalCode = findViewById(R.id.ad_code);
        phoneNumber = findViewById(R.id.ad_phone);
        addAddressBTN = findViewById(R.id.ad_add_address);
        addAddressBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userAddress = address.getText().toString();
                String userCity = city.getText().toString();
                String userpostalCode = postalCode.getText().toString();
                String userPhoneNum = phoneNumber.getText().toString();

                String finalAddress = "";

                if(!userName.isEmpty()){
                    finalAddress += userName+ ", ";
                }
                if(!userAddress.isEmpty()){
                    finalAddress += userAddress+ ", ";
                }
                if(!userCity.isEmpty()){
                    finalAddress += userCity+ ", ";
                }
                if(!userpostalCode.isEmpty()){
                    finalAddress += userpostalCode+ ", ";
                }
                if(!userPhoneNum.isEmpty()){
                    finalAddress += userPhoneNum;
                }
                ApiService.apiService.addnewAddress(1, finalAddress,userPhoneNum, userpostalCode).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(AddAddressActivity.this, "Add New Address Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddAddressActivity.this,DetailActivity.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(AddAddressActivity.this, "Add New Address Faild", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
}