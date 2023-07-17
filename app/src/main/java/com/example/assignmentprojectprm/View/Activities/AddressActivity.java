package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressActivity extends AppCompatActivity implements  AddressAdapter.SelectedAddress{


    RecyclerView recyclerView;
    List<User> listUserObj;
    Button addAddressBTN, paymentBTN;
    Toolbar toolbar;
    AddressAdapter addressAdapter;
    String mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        toolbar = findViewById(R.id.address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true );

        Object obj = getIntent().getSerializableExtra("item");

        recyclerView = findViewById(R.id.address_recycler);
        addAddressBTN = findViewById(R.id.add_address_btn);
        paymentBTN = findViewById(R.id.payment_btn);
        paymentBTN = findViewById(R.id.payment_btn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listUserObj = new ArrayList<>();
        addressAdapter = new AddressAdapter(getApplicationContext(), listUserObj, this);
        recyclerView.setAdapter(addressAdapter);

        ApiService.apiService.getInfoUser(1).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                listUserObj.add(response.body());
                addressAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        addAddressBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddressActivity.this, AddAddressActivity.class));
            }
        });




        paymentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal amount = new BigDecimal(0);
                if(obj instanceof ProductML){
                    ProductML productML = (ProductML) obj;
                    amount = productML.getPrice();
                }
                Intent intent = new Intent(AddressActivity.this, PaymentActivity.class);
                intent.putExtra("amount", amount.toString());
                startActivity(intent);
            }
        });


    }

    @Override
    public void setAddress(String address) {
        mAddress = address;
    }
}