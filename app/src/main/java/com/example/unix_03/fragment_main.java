package com.example.unix_03;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class fragment_main extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        ImageSlider imageSlider = view.findViewById(R.id.slider);
        CardView cardView1 = view.findViewById(R.id.cardView1);



        ArrayList<SlideModel> arrayList = new ArrayList<>();
        arrayList.add(new SlideModel(R.drawable.slider0, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider4, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider5, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider6, ScaleTypes.FIT));
        imageSlider.setImageList(arrayList);



        return view;
   }
}
