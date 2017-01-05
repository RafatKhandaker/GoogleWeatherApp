package com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.HorizontalScrollAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder.WeatherViewHolder;

import static com.delaroystudios.CardView_GoogleApp.Presentation.MainActivity.mainWeatherData;

/**
 * Created by RedDragon on 12/2/16.
 */

public class WeatherHorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View weatherView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_card_layout, null);

        return new WeatherViewHolder(weatherView);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WeatherViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return mainWeatherData.size();
    }
}
