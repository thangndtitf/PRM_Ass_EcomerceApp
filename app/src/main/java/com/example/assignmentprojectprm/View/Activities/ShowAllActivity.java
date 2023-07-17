package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.Model.productTypeML;
import com.example.assignmentprojectprm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ShowAllAdapter showAllAdapter;
    List<ProductML> showAllList;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        toolbar = findViewById(R.id.showalltollbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        int type= Integer.valueOf(getIntent().getStringExtra("type"));
        recyclerView = findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        showAllList = new ArrayList<>();
        showAllAdapter = new ShowAllAdapter(this, showAllList);
        recyclerView.setAdapter(showAllAdapter);

            if(type <= 0){
                ApiService.apiService.getAllProduct().enqueue(new Callback<List<ProductML>>() {
                    @Override
                    public void onResponse(Call<List<ProductML>> call, Response<List<ProductML>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            showAllList.add(response.body().get(i));
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ProductML>> call, Throwable t) {

                    }
                });
            }
            else if(type > 0){
                ApiService.apiService.getProductByType(Integer.valueOf(type)).enqueue(new Callback<List<ProductML>>() {
                    @Override
                    public void onResponse(Call<List<ProductML>> call, Response<List<ProductML>> response) {
                        for (int i = 0; i < response.body().size(); i++) {
                            showAllList.add(response.body().get(i));
                            Toast.makeText(ShowAllActivity.this, "Get product by type: "+ type+ " is OKE", Toast.LENGTH_SHORT).show();
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ProductML>> call, Throwable t) {
                        Toast.makeText(ShowAllActivity.this, "Get product by type: "+ type+ " is null", Toast.LENGTH_SHORT).show();
                    }
                });
            }


    }
}