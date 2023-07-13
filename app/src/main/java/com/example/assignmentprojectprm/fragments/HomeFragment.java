package com.example.assignmentprojectprm.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.assignmentprojectprm.Domain.Api.ApiService;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.Model.productTypeML;
import com.example.assignmentprojectprm.R;
import com.example.assignmentprojectprm.View.Activities.CategoryAdapter;
import com.example.assignmentprojectprm.View.Activities.NewProductsApdater;
import com.example.assignmentprojectprm.View.Activities.PopularProductAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    LinearLayout linearLayout;
    ProgressDialog progressDialog;
    RecyclerView catRecyclerView, newProductRecyclerView, popularRecyclerView;
    //Category recyclerview
    CategoryAdapter categoryAdapter;
    List<productTypeML> productTypeMLList;
    //New Product Recyclerview
    NewProductsApdater newProductsApdater;
    List<ProductML> listProductML;

    //Popular Products
    PopularProductAdapter popularProductAdapter;
    List<ProductML> listPopularProduct;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=  inflater.inflate(R.layout.fragment_home, container, false);

        progressDialog = new ProgressDialog(getActivity());
        catRecyclerView = root.findViewById(R.id.rec_category);
        newProductRecyclerView = root.findViewById(R.id.new_product_rec);
        popularRecyclerView = root.findViewById(R.id.popular_rec);
        linearLayout = root.findViewById(R.id.home_layout);
        linearLayout.setVisibility(View.GONE);
        //Image Slider
        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banner1,"Discount On Product Item", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2,"Discount On Perfume", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3,"60% OFF", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);

        progressDialog.setTitle("Welcome To My Ecomerce App");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        //Category
        catRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        productTypeMLList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(), productTypeMLList);
        catRecyclerView.setAdapter(categoryAdapter);

        ApiService.apiService.getAllProductType().enqueue(new Callback<List<productTypeML>>() {
            @Override
            public void onResponse(Call<List<productTypeML>> call, Response<List<productTypeML>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    productTypeMLList.add(response.body().get(i));
                    categoryAdapter.notifyDataSetChanged();
                    linearLayout.setVisibility(View.VISIBLE);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<productTypeML>> call, Throwable t) {

            }
        });


        //New Product
        newProductRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        listProductML = new ArrayList<>();
        newProductsApdater = new NewProductsApdater(getContext(), listProductML);
        newProductRecyclerView.setAdapter(newProductsApdater);
        ApiService.apiService.getAllProduct().enqueue(new Callback<List<ProductML>>() {
            @Override
            public void onResponse(Call<List<ProductML>> call, Response<List<ProductML>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    listProductML.add(response.body().get(i));
                    newProductsApdater.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<ProductML>> call, Throwable t) {

            }
        });

        //PopularProduct
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        listPopularProduct = new ArrayList<>();
        popularProductAdapter = new PopularProductAdapter(getContext(), listPopularProduct);
        popularRecyclerView.setAdapter(popularProductAdapter);
        ApiService.apiService.getAllProduct().enqueue(new Callback<List<ProductML>>() {
            @Override
            public void onResponse(Call<List<ProductML>> call, Response<List<ProductML>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    listPopularProduct.add(response.body().get(i));
                    popularProductAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<ProductML>> call, Throwable t) {

            }
        });
        return root;
    }
}