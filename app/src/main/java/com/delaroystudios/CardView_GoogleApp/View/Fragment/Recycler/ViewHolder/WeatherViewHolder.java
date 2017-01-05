package com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.delaroystudios.CardView_GoogleApp.MainActivity.currentDateTimeString;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.currentHumidityWeatherData;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.currentTempWeatherData;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.dateWeatherData;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.mainWeatherData;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.setIcon;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.windSpeedWeatherData;

/**
 * Created by RedDragon on 11/19/16.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

@Nullable @BindView(R.id.weather_image_icon) ImageView weatherImageIcon;
@Nullable @BindView(R.id.current_weather_textview) TextView currentWeatherTextView;
@Nullable @BindView(R.id.current_wind_speed) TextView currentWindSpeedTextView;
@Nullable @BindView(R.id.current_humidity) TextView currentHumidity;
@Nullable @BindView(R.id.date_text_view) TextView dateTextView;
@Nullable @BindView(R.id.weather_horizontal_recycler) public RecyclerView weatherHorizontalRecyclerView;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(int i){

        String getCurrentWeatherText = "temp: "
                +currentTempWeatherData.get(i).toString().substring(0,4);

        String getCurrentWindText = "wind speed: "
                +windSpeedWeatherData.get(i).toString().substring(0,4);

        String getCurrentHumidity = "humidity: "
                +currentHumidityWeatherData.get(i).toString().substring(0,4);

       if(dateWeatherData.size() != 0){
           dateTextView.setText(dateWeatherData.get(i).toString());
       } else{ dateTextView.setText(currentDateTimeString); }

        currentWeatherTextView.setText(getCurrentWeatherText);
        currentWindSpeedTextView.setText(getCurrentWindText);
        currentHumidity.setText(getCurrentHumidity);
        weatherImageIcon.setImageResource(setIcon.get(mainWeatherData.get(i)));

    }

    public Context getContext(){
        return weatherHorizontalRecyclerView.getContext();
    }

}
