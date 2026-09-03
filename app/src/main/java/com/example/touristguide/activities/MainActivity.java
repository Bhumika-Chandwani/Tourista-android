package com.example.touristguide.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.touristguide.R;
import com.example.touristguide.fragments.HomeFragment;
import com.example.touristguide.fragments.MyTripsFragment;
import com.example.touristguide.fragments.ProfileFragment;
import com.example.touristguide.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        setupBottomNavigation();

        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
            bottomNavigation.setSelectedItemId(R.id.nav_home);
        }
    }

    private void setupBottomNavigation() {

        bottomNavigation.setOnItemSelectedListener(item -> {

            Fragment fragment;

            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                fragment = new HomeFragment();

            } else if (itemId == R.id.nav_search) {
                fragment = new SearchFragment();

            } else if (itemId == R.id.nav_trips) {
                fragment = new MyTripsFragment();

            } else if (itemId == R.id.nav_profile) {
                fragment = new ProfileFragment();

            } else {
                return false;
            }

            loadFragment(fragment);
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}