package com.example.assignmentprojectprm.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentprojectprm.Model.SaleOrderDetailML;
import com.example.assignmentprojectprm.Model.SaleOrderML;
import com.example.assignmentprojectprm.R;

import java.math.BigDecimal;
import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
    Context contex;
    List<SaleOrderDetailML> list;
    BigDecimal totalAMount = new BigDecimal(0);

    public MyCartAdapter(Context contex, List<SaleOrderDetailML> list) {
        this.contex = contex;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyCartAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cart_item,parent,false));    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(String.valueOf(list.get(position).getProductID()));
        holder.time.setText(String.valueOf(list.get(position).getProductID()));
        holder.price.setText(list.get(position).getProductPrice().toString() + " $");
        holder.totalPrice.setText(list.get(position).getTotalPrice().toString() + " $");
        holder.totalPrice.setText(String.valueOf(list.get(position).getQuantity()));
        holder.name.setText(String.valueOf(list.get(position).getProductID()));

        totalAMount= list.get(position).getTotalPrice().add(totalAMount);
        Intent intent = new Intent("MyTotalAmount");
        intent.putExtra("totalAmount", totalAMount.toString());
        LocalBroadcastManager.getInstance(contex).sendBroadcast(intent);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price,date,time,totalQuantity,totalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            date = itemView.findViewById(R.id.current_date);
            time = itemView.findViewById(R.id.current_time);
            totalQuantity = itemView.findViewById(R.id.total_quantity);
            totalPrice = itemView.findViewById(R.id.total_price);
        }
    }
}
