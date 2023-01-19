package com.example.unix_03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unix_03.Database.OrderContract;

public class shirt8 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    RadioButton smallBtn, mediumBtn, largeBtn;
    ImageButton plusquantity, minusquantity, nextLeft, nextRight, back;
    TextView quantitynumber, shirtName, shirtsPrice, description;
    CheckBox addLarge, addSmall;
    Button addtoCart, resetBtn;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);




        back = findViewById(R.id.back);
        nextLeft = findViewById(R.id.nextLeft);
        nextRight = findViewById(R.id.nextRight);
        description = findViewById(R.id.descriptioninfo);
        smallBtn = findViewById(R.id.smallBtn);
        mediumBtn = findViewById(R.id.mediumBtn);
        largeBtn = findViewById(R.id.largeBtn);
        resetBtn = findViewById(R.id.resetBtn);
        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        shirtName = findViewById(R.id.shirtNameinInfo);
        shirtsPrice = findViewById(R.id.shirtPrice);
        addLarge = findViewById(R.id.addLarge);
        addtoCart = findViewById(R.id.addtocart);
        addSmall = findViewById(R.id.addSmall);



        imageView.setImageResource(R.drawable.tshirt1);
        shirtName.setText("Gucci");
        description.setText("Add some personality to your outfit with our eye-catching t-shirt.");







        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(shirt8.this, OrderMain.class);
                startActivity(intent);
            }
        });


        nextLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(shirt8.this, shirt7.class);
                startActivity(intent);
            }
        });

        nextRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(shirt8.this, "No more shirt", Toast.LENGTH_SHORT).show();
            }
        });


        displayQuantity();


        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                quantity = 0;
                String setnewPrice = String.valueOf(quantity);
                shirtsPrice.setText("Total: $" + setnewPrice);


                displayQuantity();

            }
        });



        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if(quantity == 0){


                    Toast.makeText(shirt8.this,"Items with a quantity less than one cannot be added to the cart.", Toast.LENGTH_SHORT).show();

                }else if(smallBtn.isChecked() || largeBtn.isChecked() || mediumBtn.isChecked()){
                    SaveCart();

                }
                else{
                    Toast.makeText(shirt8.this, "Please add your size", Toast.LENGTH_SHORT).show();




                }


            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // shirt price
                int basePrice = 5;
                quantity++;
                displayQuantity();
                int shirtPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(shirtPrice);
                shirtsPrice.setText(setnewPrice);

                int ifCheckBox = CalculatePrice(addSmall, addLarge, smallBtn, mediumBtn, largeBtn);
                shirtsPrice.setText("Total: $ " + ifCheckBox);

            }
        });
        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;

                if (quantity == 0) {
                    Toast.makeText(shirt8.this, "Quantity is already 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int shirtPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(shirtPrice);
                    shirtsPrice.setText(setnewPrice);


                    int ifCheckBox = CalculatePrice(addSmall, addLarge, smallBtn, mediumBtn, largeBtn);
                    shirtsPrice.setText("Total: $ " + ifCheckBox);

                }
            }
        });
    }


    private boolean SaveCart() {


        String name = shirtName.getText().toString();
        String price = shirtsPrice.getText().toString();
        String quantity = quantitynumber.getText().toString();


        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);


        if (addLarge.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_LARGE, "Glitter Upgrade: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_LARGE, "Dri Fit Upgrade: NO");

        }

        if (addSmall.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_SMALL, "Dri Fit Upgrade: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_SMALL, "Glitter Upgrade: NO");

        }

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                showDialog();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }


    private int CalculatePrice(CheckBox addSmall, CheckBox addLarge, RadioButton smallBtn,
                               RadioButton mediumBtn, RadioButton largeBtn) {
        int basePrice = 5;

        if (addSmall.isChecked()) {
            basePrice = basePrice + 2;
        }

        if (addLarge.isChecked()) {

            basePrice = basePrice + 2;
        }
        if (smallBtn.isChecked()) {
            // topping cost is $3
            basePrice = basePrice + 0;
        }
        if (mediumBtn.isChecked()) {
            // topping cost is $3
            basePrice = basePrice + 2;

        }
        if (largeBtn.isChecked()) {
            // topping cost is $3
            basePrice = basePrice + 3;

        }

        return basePrice * quantity;
    }


    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }



    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SMALL,
                OrderContract.OrderEntry.COLUMN_LARGE
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int small = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SMALL);
            int large = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_LARGE);


            String nameofshirt = cursor.getString(name);
            String priceofshirt = cursor.getString(price);
            String quantityofshirt = cursor.getString(quantity);
            String yesSmall = cursor.getString(small);
            String yesLarge = cursor.getString(large);
            shirtName.setText(nameofshirt);
            shirtsPrice.setText(priceofshirt);
            quantitynumber.setText(quantityofshirt);
        }


    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        shirtName.setText("");
        shirtsPrice.setText("");
        quantitynumber.setText("");

    }


    void showDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_dialog, null);

//        Button viewCart = findViewById(R.id.viewCart);
//        Button orderMore = findViewById(R.id.OrderMore);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setPositiveButton("View my cart", null)
                .setNegativeButton("Order more", null)

                .setView(view)
                .create();
        alertDialog.show();
        alertDialog.setCancelable(true);

        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(shirt8.this, summaryActivity.class);
                startActivity(intent);
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(shirt8.this, OrderMain.class);
                startActivity(intent);

            }
        });




    }}

