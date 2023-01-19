package com.example.unix_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class trending extends AppCompatActivity  {
    private RecyclerView mRecycleView;
    private List<String> titles;
    private List<Integer> mImages;
    private MyAdapter adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        mRecycleView = findViewById(R.id.recyclerViews);
        ImageButton gobacks = findViewById(R.id.goBacks);

        gobacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trending.this,navigation_activity.class);
                startActivity(intent);
            }
        });

        titles = new ArrayList<>();
        mImages = new ArrayList<>();

        adaptor = new MyAdapter(this , titles , mImages);

        mImages.add(R.drawable.tshirt1);
        mImages.add(R.drawable.tshirt2);
        mImages.add(R.drawable.tshirt3);
        mImages.add(R.drawable.img4);
        mImages.add(R.drawable.img5);
        mImages.add(R.drawable.img6);
        mImages.add(R.drawable.img7);
        mImages.add(R.drawable.img8);
        mImages.add(R.drawable.tshirt1);
        mImages.add(R.drawable.tshirt2);
        mImages.add(R.drawable.tshirt3);
        mImages.add(R.drawable.img4);
        mImages.add(R.drawable.img5);
        mImages.add(R.drawable.img6);
        mImages.add(R.drawable.img7);
        mImages.add(R.drawable.img8);

        titles.add("Gucci");
        titles.add("Gucci");
        titles.add("Adidas");
        titles.add("Nike");
        titles.add("Gucci");
        titles.add("H&M");
        titles.add("Lacoste");
        titles.add("Nike");
        titles.add("Gucci");
        titles.add("Gucci");
        titles.add("Adidas");
        titles.add("Nike");
        titles.add("Gucci");
        titles.add("H&M");
        titles.add("Lacoste");
        titles.add("Nike");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 3 , GridLayoutManager.VERTICAL , false);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setAdapter(adaptor);



    }
    }
