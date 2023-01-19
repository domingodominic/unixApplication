package com.example.unix_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unix_03.Database.OrderContract;

public class summaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter mAdapter;
    public static final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);



        Button clearthedata = findViewById(R.id.clearthedatabase);
        Button orderMore = findViewById(R.id.orderMore);
        ImageButton back = findViewById(R.id.back1);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(summaryActivity.this, "HELLOOOO", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(summaryActivity.this, navigation_activity.class);
                startActivity(intent);


            }
        });


        orderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(summaryActivity.this, OrderMain.class);
                startActivity(intent);
            }
        });

        clearthedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
            }
        });

        getLoaderManager().initLoader(LOADER, null, this);

        ListView listView = findViewById(R.id.list);
        mAdapter = new CartAdapter(this, null);
        listView.setAdapter(mAdapter);



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SMALL,
                OrderContract.OrderEntry.COLUMN_LARGE
        };

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.swapCursor(null);
    }
}