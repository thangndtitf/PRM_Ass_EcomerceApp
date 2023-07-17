package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.Model.SaleOrderDetailML;
import com.example.assignmentprojectprm.Model.SaleOrderML;
import com.example.assignmentprojectprm.Model.SaleOrderReBD;
import com.example.assignmentprojectprm.R;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {


    ImageView detailedImg;
    TextView rating,name,description,price,quantity;
    Button addToCart,buyNow;
    ImageView addItems,removeItems;

    Toolbar toolbar;
    int totalQuantity = 1;
    BigDecimal totalPrice ;

    ProductML newProduct = null;
    ProductML popularProduct = null;

    ProductML showAllProduct=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.detailed_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Object obj = getIntent().getSerializableExtra("detailed");

        if(obj instanceof ProductML){
        newProduct = (ProductML) obj;
        }else if(obj instanceof ProductML){
            popularProduct = (ProductML) obj;
        }else if(obj instanceof ProductML){
            showAllProduct = (ProductML) obj;
        }


        detailedImg = findViewById(R.id.detailed_img);
        quantity = findViewById(R.id.quantity);
        name = findViewById(R.id.detailed_name);
        description = findViewById(R.id.detailed_desc);
        price = findViewById(R.id.detail_price);
        rating = findViewById(R.id.rating);
        addToCart = findViewById(R.id.add_to_Cart);
        buyNow = findViewById(R.id.buy_now);
        addItems = findViewById(R.id.add_item);
        removeItems = findViewById(R.id.remove_item);
        if(newProduct != null){
            Glide.with(getApplicationContext()).load(newProduct.getDescription()).into(detailedImg);
            name.setText(newProduct.getProductName());
            price.setText( newProduct.getPrice().toString());
            description.setText(newProduct.getDescription());
            totalPrice = newProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
        }

        if(popularProduct != null){
            Glide.with(getApplicationContext()).load(popularProduct.getDescription()).into(detailedImg);
            name.setText(popularProduct.getProductName());
            price.setText( popularProduct.getPrice().toString());
            description.setText(popularProduct.getDescription());
            totalPrice = popularProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
        }

        if(showAllProduct != null){
            Glide.with(getApplicationContext()).load(showAllProduct.getDescription()).into(detailedImg);
            name.setText(showAllProduct.getProductName());
            price.setText( showAllProduct.getPrice().toString());
            description.setText(showAllProduct.getDescription());
            totalPrice = showAllProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
        }


        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, AddressActivity.class);
                if(newProduct != null){
                    intent.putExtra("item", newProduct);
                }
                if(popularProduct != null){
                    intent.putExtra("item", popularProduct);
                }
                if(showAllProduct != null){
                    intent.putExtra("item", showAllProduct);
                }

                startActivity(intent);
            }
        });

        //Add to Cart Listener
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addtoCart();
            }

            private void addtoCart() {
//                String saveCurrentTime, saveCurrentDate;
//                Calendar calendar = Calendar.getInstance();
//                SimpleDateFormat currentDate = new SimpleDateFormat("yyy-MM-DD");
//                saveCurrentDate = currentDate.format(calendar.getTime());
//
//                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
//                saveCurrentTime = currentTime.format(calendar.getTime());
//
//                final HashMap<String,Object> cartMap = new HashMap<>();
//                cartMap.put("productName", name.getText().toString());
//                cartMap.put("productPrice", price.getText().toString());
//                cartMap.put("currentTime", saveCurrentTime);
//                cartMap.put("currentDate", saveCurrentDate);

                SaleOrderML saleOrderML = new SaleOrderML(0,1,1, null,"Thawnsg",1 );
                ProductML Product = (ProductML) obj;
                SaleOrderDetailML saleOrderDetailML = new SaleOrderDetailML(0,0,Product.getProductID(),totalQuantity,totalPrice,Product.getPrice(),Product.getPrice());
                List<SaleOrderDetailML> listSODetail = new ArrayList<>();
                listSODetail.add(saleOrderDetailML);
                ApiService.apiService.insertNewSaleOrder(new SaleOrderReBD(saleOrderML,listSODetail)).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Toast.makeText(DetailActivity.this, "saleOrderID: "+ response.body().toString(), Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(DetailActivity.this, "cretae Fail", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });

        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQuantity<10){
                    totalQuantity ++;
                    quantity.setText(String.valueOf(totalQuantity));
                    if( newProduct != null){
                        totalPrice = newProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
                    }
                    if( popularProduct != null){
                        totalPrice = popularProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
                    }
                    if( showAllProduct != null){
                        totalPrice = showAllProduct.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
                    }
                }
            }
        });
        removeItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(totalQuantity>1){
                    totalQuantity --;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });

    }
}