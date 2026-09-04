package com.example.touristguide.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touristguide.R;
import com.example.touristguide.models.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private final List<City> cityList;

    public CityAdapter(List<City> cityList) {
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CityViewHolder holder,
            int position) {

        City city = cityList.get(position);

        holder.tvCityName.setText(city.getName());
        holder.tvCityState.setText(city.getState());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {

        TextView tvCityName;
        TextView tvCityState;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCityName = itemView.findViewById(R.id.tvCityName);
            tvCityState = itemView.findViewById(R.id.tvCityState);
        }
    }
}