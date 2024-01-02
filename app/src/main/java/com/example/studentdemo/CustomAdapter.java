package com.example.studentdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentdemo.callback.RecyclerViewCallBack;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<String> list;
    RecyclerViewCallBack recyclerViewCallBack;

    CustomAdapter(ArrayList<String> list, RecyclerViewCallBack recyclerViewCallBack){
        this.list = list;
        this.recyclerViewCallBack= recyclerViewCallBack;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String data= list.get(position);
        holder.txtStudentName.setText(data);
        holder.txtStudentName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerViewCallBack.itemClickEvent(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
 class MyViewHolder extends RecyclerView.ViewHolder{
    AppCompatTextView txtStudentName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtStudentName=(AppCompatTextView) itemView.findViewById(R.id.txtStudentName);

    }
}
