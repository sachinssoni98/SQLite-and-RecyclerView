package com.example.sqliteproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterClass extends RecyclerView.Adapter<RecyclerViewAdapterClass.ViewHolder> {
ArrayList<Data> arrayList;
    public RecyclerViewAdapterClass(ArrayList<Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(arrayList.get(position).getName());
    holder.age.setText(arrayList.get(position).getAge());
    holder.city.setText(arrayList.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,age,city;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            age= itemView.findViewById(R.id.age);
            city= itemView.findViewById(R.id.city);
        }
    }
}
