package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.SaleOrderDetailML;
import com.example.assignmentprojectprm.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<SaleOrderDetailML> cartList;
    MyCartAdapter cartAdapter;
    TextView overAllAmount;
    Button buyNow;
    int overAllTotalMount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        toolbar = findViewById(R.id.mycarttollbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buyNow = findViewById(R.id.car_buy_now);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,new IntentFilter("MyTotalAmount"));
        overAllAmount = findViewById(R.id.textView3);
        recyclerView= findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartList = new ArrayList<>();
        cartAdapter = new MyCartAdapter(this,cartList);
        recyclerView.setAdapter(cartAdapter);
        ApiService.apiService.getListSoDetail(1).enqueue(new Callback<List<SaleOrderDetailML>>() {
            @Override
            public void onResponse(Call<List<SaleOrderDetailML>> call, Response<List<SaleOrderDetailML>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    cartList.add(response.body().get(i));
                    cartAdapter.notifyDataSetChanged();
                }
                Toast.makeText(CartActivity.this, "get List Cart Oke", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<SaleOrderDetailML>> call, Throwable t) {

            }
        });

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, AddressActivity.class);
//                if(newProduct != null){
//                    intent.putExtra("item", newProduct);
//                }
//                if(popularProduct != null){
//                    intent.putExtra("item", popularProduct);
//                }
//                if(showAllProduct != null){
//                    intent.putExtra("item", showAllProduct);
//                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("listItem", (Serializable) cartList);
                intent.putParcelableArrayListExtra("listItem", (ArrayList<? extends Parcelable>) cartList);
                startActivity(intent);
            }
        });

    }



    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BigDecimal totalBill = new BigDecimal(intent.getStringExtra("totalAmount"));
            overAllAmount.setText("Total Amount : " + totalBill.toString() + "$");
        }
    };
}