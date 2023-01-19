package com.example.unix_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderMain extends AppCompatActivity {
    List<Model> modelList;
   RecyclerView recyclerView;

    private SearchView searchView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_main);
        modelList = new ArrayList<>();
        modelList.add(new Model("Gucci", "White cotton that is stylish and convenient Gucci t-shirt", R.drawable.slider1 ));
        modelList.add(new Model("Lacoste", "Stay cool and look great in our breathable Lacoste t-shirt.", R.drawable.slider2));
        modelList.add(new Model("Adidas", "Experience ultimate comfort in our soft and lightweight Adidas t-shirt.", R.drawable.slider4));
        modelList.add(new Model("Nike", "Stay on trend with our fashionable Nike t-shirt.", R.drawable.shirt2));
        modelList.add(new Model("Gucci", "Get the perfect blend of style and comfort with our Gucci t-shirt.", R.drawable.slider5));
        modelList.add(new Model("H&M", "Upgrade your casual look with our stylish H&M t-shirt.", R.drawable.slider6));
        modelList.add(new Model("lacoste","Stay comfortable and fashionable in our top-selling Lacoste t-shirt.", R.drawable.shirt1));
        modelList.add(new Model("Nike","Add some personality to your outfit with our eye-catching t-shirt.", R.drawable.tshirt2));
        modelList.add(new Model("Gucci","Get the perfect fit and fashionable design with our t-shirt.", R.drawable.tshirt1));

        ImageButton goBack = findViewById(R.id.goBack);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });



        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMain.this, navigation_activity.class);
                startActivity(intent);
            }
        });


        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);






    }
    private void filterList(String text) {
        List<Model> filteredList = new ArrayList<>();

        for(Model model : modelList){

            if(model.getmDrinkName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(model);

            }   }
        if(filteredList.isEmpty()){

            Toast.makeText(this,"Item not found", Toast.LENGTH_SHORT).show();
        }else{
            mAdapter.setFilteredList(filteredList);
        }



    }
}