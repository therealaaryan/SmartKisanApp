package com.example.smartkisanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;


    ArrayList<helper_cow> list;

    public MyAdapter(Context context, ArrayList<helper_cow> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cow_item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        helper_cow user = list.get(position);
        holder.cow_type.setText(user.getCow_type());
        holder.cow_name.setText(user.getCow_name());
        holder.age.setText(user.getAge());
        holder.medical_info.setText(user.getMedical_info());
        holder.milk.setText(user.getMilk());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cow_type, cow_name, age, medical_info, milk;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cow_type = itemView.findViewById(R.id.cow_type);
            cow_name = itemView.findViewById(R.id.cow_name);
            age = itemView.findViewById(R.id.cow_age);
            medical_info = itemView.findViewById(R.id.cow_medical);
            milk = itemView.findViewById(R.id.cow_milk);
        }
    }
}
