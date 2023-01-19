package com.example.unix_03;

public class Model {

    String mShirtName;
    String mShirtDetail;
    int mShirtPhoto;

    public Model(String mShirtName, String mShirtDetail, int mShirtPhoto) {
        this.mShirtName = mShirtName;
        this.mShirtDetail = mShirtDetail;
        this.mShirtPhoto = mShirtPhoto;
    }




    public String getmDrinkName() {
        return mShirtName;
    }

    public String getmDrinkDetail() {
        return mShirtDetail;
    }

    public int getmDrinkPhoto() {
        return mShirtPhoto;
    }
}


