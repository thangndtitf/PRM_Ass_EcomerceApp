package com.example.assignmentprojectprm.View.Activities;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentprojectprm.Model.ProductML;
import com.example.assignmentprojectprm.R;

import org.w3c.dom.Text;

import java.util.List;

public class PopularProductAdapter extends RecyclerView.Adapter<PopularProductAdapter.ViewHolder> {
    private Context context;
    private List<ProductML> popularProducts;

    public PopularProductAdapter(Context context, List<ProductML> popularProducts) {
        this.context = context;
        this.popularProducts = popularProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(popularProducts.get(position).getProductName());
        holder.price.setText( popularProducts.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return popularProducts.size();
    }

    public class   ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.all_img);
            name = itemView.findViewById(R.id.all_product_name);
            price = itemView.findViewById(R.id.all_price);
        }
    }
}
