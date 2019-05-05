package com.rojinonlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.AdapterItems;
import model.ItemProperties;

public class Dashboard extends AppCompatActivity {

    private Button btnAddItem;
    private RecyclerView recyclerView;
    List<ItemProperties> itemPropertiesList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnAddItem=findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Dashboard.this, RojinAddItemActivity.class);
                startActivity(I);
            }
        });

        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new AdapterItems(getApplicationContext(),itemPropertiesList));


        readItemsData();


    }


    private void readItemsData() {
        try {
            FileInputStream fos=openFileInput("items.txt");
            InputStreamReader isr=new InputStreamReader(fos);

            BufferedReader br=new BufferedReader(isr);
            String line="";

            while ((line = br.readLine()) != null){
                String[] parts = line.split("->");
                String imgDrawagble =parts[0];
                int id=getResources().getIdentifier(imgDrawagble,"drawable",getPackageName());
                itemPropertiesList.add(new ItemProperties(parts[0],parts[1],parts[2],parts[3],id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
