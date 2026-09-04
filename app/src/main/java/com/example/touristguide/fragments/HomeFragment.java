package com.example.touristguide.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touristguide.R;
import com.example.touristguide.adapters.CityAdapter;
import com.example.touristguide.models.City;
import com.example.touristguide.utils.FirebaseUtil;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rvCities;
    private CityAdapter cityAdapter;

    private final List<City> cityList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home,
                container,
                false
        );

        rvCities = view.findViewById(R.id.rvCities);

        setupRecyclerView();
        loadCities();

        return view;
    }

    private void setupRecyclerView() {

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                );

        rvCities.setLayoutManager(layoutManager);

        cityAdapter = new CityAdapter(cityList);
        rvCities.setAdapter(cityAdapter);
    }

    private void loadCities() {

        FirebaseUtil.getFirestore()
                .collection("cities")
                .get()
                .addOnSuccessListener(querySnapshot -> {

                    cityList.clear();

                    for (DocumentSnapshot document : querySnapshot.getDocuments()) {

                        City city = document.toObject(City.class);

                        if (city != null) {
                            city.setId(document.getId());
                            cityList.add(city);
                        }
                    }

                    cityAdapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {

                    e.printStackTrace();
                });
    }
}