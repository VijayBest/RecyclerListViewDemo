package com.example.studentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.studentdemo.callback.RecyclerViewCallBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerListViewDemo extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list_view_demo);
        intiView();
    }

    private void intiView() {

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        setCustomAdapter();

    }

    private void setCustomAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        List<String> itemList = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 3", "Item 3");
        customAdapter = new CustomAdapter(new ArrayList<>(itemList), new RecyclerViewCallBack() {
            @Override
            public void itemClickEvent(String data) {
                
                Toast.makeText(RecyclerListViewDemo.this, data, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(customAdapter);

    }
}