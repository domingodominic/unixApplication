package com.example.unix_03;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button btnlogin = view.findViewById(R.id.btnlogin);
        EditText username = view.findViewById(R.id.username);
        EditText password = view.findViewById(R.id.password);








        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin")){

                    Intent intent = new Intent(getActivity(),navigation_activity.class);
                    startActivity(intent);


                }
                else if(username.getText().toString() != ("admin") && password.getText().toString() != ("admin")){
                    Toast.makeText(getActivity(),"Please input valid username and password", Toast.LENGTH_SHORT).show();



                }

            }
        });


        return view;






    }

}