package com.example.assignmentprojectprm.View.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.R;

import java.math.BigDecimal;
import java.util.List;

public class NewProductsApdater extends RecyclerView.Adapter<NewProductsApdater.ViewHolder> {


    private Context context;
    private List<ProductML> listProduct;

    public NewProductsApdater(Context context, List<ProductML> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_products,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(context).load(listProduct.get(position).getDescription()).into(holder.newImg);
        holder.newProductName.setText(listProduct.get(position).getProductName());
        holder.newPrice.setText(listProduct.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView newImg;
        TextView newProductName, newPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newImg  = itemView.findViewById(R.id.new_img);
            newProductName = itemView.findViewById(R.id.new_product_name);
            newPrice = itemView.findViewById(R.id.new_price);
        }
    }
}
