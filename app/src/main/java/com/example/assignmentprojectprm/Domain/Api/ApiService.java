package com.example.assignmentprojectprm.Domain.Api;

import com.example.assignmentprojectprm.Model.LoginObj;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.Model.productTypeML;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("yyy-mm-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://a231-125-235-239-147.ngrok-free.app")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService.class);


    @GET("getInforCustomer")
    Call<User> getInfoUser(@Query("customerID") int cusID);

    @POST("Login")
    Call<User> login(@Body LoginObj loginObj);

    @GET("getAllProductType")
    Call<List<productTypeML>> getAllProductType();

    @GET("getAllProduct")
    Call<List<ProductML>> getAllProduct();



}
