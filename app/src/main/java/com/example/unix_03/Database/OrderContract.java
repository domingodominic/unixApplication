package com.example.unix_03.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {
    public OrderContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.unix_03";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // dapat similar to sa table name
    public static final String PATH = "orderig";


    public static abstract class OrderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        public static final String TABLE_NAME = "orderig";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_LARGE = "large";
        public static final String COLUMN_SMALL = "small";

    }
}
