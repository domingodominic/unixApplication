package com.example.unix_03;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.example.unix_03.Database.OrderContract;

public class CartAdapter extends CursorAdapter {
    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView shirtName, small, large, price, quantity;


        shirtName = view.findViewById(R.id.shirtNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
       small = view.findViewById(R.id.small);
      large = view.findViewById(R.id.large);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofshirt = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofshirt = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int Yessmall = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SMALL);
        int Yeslarge = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_LARGE);


        String nameofshirt = cursor.getString(name);
        String pricesofshirt = cursor.getString(priceofshirt);
        String quantitysofshirt = cursor.getString(quantityofshirt);
        String itsmall = cursor.getString(Yessmall);
        String itslarge = cursor.getString(Yeslarge);



        shirtName.setText(nameofshirt);
        price.setText(pricesofshirt);
        small.setText(itsmall);
        large.setText(itslarge);
        quantity.setText(quantitysofshirt);





    }
}
