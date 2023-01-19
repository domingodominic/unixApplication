package com.example.unix_03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class navigation_activity extends AppCompatActivity {



    private SearchView searchView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        ImageButton myCart = findViewById(R.id.myCart);



        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new fragment_main());
        fragmentTransaction.commit();


        myCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(navigation_activity.this, summaryActivity.class);
                startActivity(intent);
            }
        });

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);

                drawerLayout.closeDrawer(GravityCompat.START);


                switch(id){
                    case R.id.nav_home:
                        Intent intent = new Intent( navigation_activity.this , navigation_activity.class);
                        startActivity(intent);
//                        replaceFragment(new HomeFragment());
                      break;
                    case R.id.nav_cart:
                        Intent intent4 = new Intent( navigation_activity.this , summaryActivity.class);
                        startActivity(intent4);
//                        replaceFragment(new CartFragment());
                       break;
                    case R.id.nav_trending:
                       Intent intent2 = new Intent(navigation_activity.this,OrderMain.class);
                       startActivity(intent2);
                        break;
                    case R.id.nav_like:
                        Intent intent3 = new Intent(navigation_activity.this, trending.class);
                        startActivity(intent3);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new AboutusFragment()).commit();
//                        replaceFragment(new AboutusFragment());
                        break;
                    case R.id.nav_profle:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new ProfileFragment()).commit();
//                         replaceFragment(new ProfileFragment());
                        break;
                    case R.id.nav_notif:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new NotificationFragment()).commit();
//                        replaceFragment(new NotificationFragment()); break;
                    default: return true;



                }
                return true;
            }
        });}}





//    private void filterList(String text) {
//
//
//        List<String> filteredList = new ArrayList<>();
//        for (String string : titles){
//            if(string.getAdaptor().toLowerCase().contains(text.toLowerCase())){
//
//                filteredList.add(string);
//
//            }
//
//        }
//
//    }

//    private void replaceFragment(Fragment fragment){
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.commit();
//    }
