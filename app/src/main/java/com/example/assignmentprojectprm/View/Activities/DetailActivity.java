package com.example.assignmentprojectprm.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.R;

public class DetailActivity extends AppCompatActivity {


    ImageView detailedImg;
    TextView rating,name,description,price;
    Button addToCart,buyNow;
    ImageView addItems,removeItems;

    ProductML newProduct = null;
    ProductML popularProduct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Object obj = getIntent().getSerializableExtra("detailed");

        if(obj instanceof ProductML){
        newProduct = (ProductML) obj;
        }else if(obj instanceof ProductML){
            popularProduct = (ProductML) obj;
        }


        detailedImg = findViewById(R.id.detailed_img);
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
        }

        if(popularProduct != null){
            Glide.with(getApplicationContext()).load(popularProduct.getDescription()).into(detailedImg);
            name.setText(popularProduct.getProductName());
            price.setText( popularProduct.getPrice().toString());
            description.setText(popularProduct.getDescription());
        }


    }
}