package com.example.assignmentprojectprm.View.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentprojectprm.Model.User;
import com.example.assignmentprojectprm.R;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    Context context;
    List<User> listUserAdd;
    SelectedAddress selectedAddress;

    private RadioButton selectedRadioBtn;
    public AddressAdapter(Context context, List<User> listUserAdd, SelectedAddress selectedAddress) {
        this.context = context;
        this.listUserAdd = listUserAdd;
        this.selectedAddress = selectedAddress;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AddressAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.address.setText(listUserAdd.get(position).getCusFullAddress());
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(User user : listUserAdd){
                    user.setSelected(false);
                }
                listUserAdd.get(position).setSelected(true);
                if(selectedRadioBtn!= null){
                    selectedRadioBtn.setChecked(false);
                }
                selectedRadioBtn = (RadioButton) view;
                selectedRadioBtn.setChecked(true);
                selectedAddress.setAddress(listUserAdd.get(position).getCusFullAddress());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUserAdd.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView address;
        RadioButton radioButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address_add);
            radioButton = itemView.findViewById(R.id.select_address);
        }
    }

    public interface SelectedAddress{
        void setAddress(String address);
    }
}
