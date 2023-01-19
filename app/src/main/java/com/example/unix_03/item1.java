package com.example.unix_03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class item1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item1);



        Button addtocart = findViewById(R.id.addtocart);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showDialog();
            }
        });


    }

    private void showDialog() {


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.unavailable_dialog, null);

//        Button viewCart = findViewById(R.id.viewCart);
//        Button orderMore = findViewById(R.id.OrderMore);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setPositiveButton("Go to trending", null)


                .setView(view)
                .create();
        alertDialog.show();
        alertDialog.setCancelable(true);

        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item1.this, OrderMain.class);
                startActivity(intent);
            }
        });


    }
}