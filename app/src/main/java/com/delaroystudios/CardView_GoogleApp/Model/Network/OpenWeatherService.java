package com.delaroystudios.CardView_GoogleApp.Model.Network;

import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.OpenWeather.OpenWeatherPOJO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RedDragon on 12/2/16.
 */

public interface OpenWeatherService {

    @GET("2.5/forecast/city?id=5128581&APPID=" +token.openWeatherKey)
    Call<OpenWeatherPOJO> getOpenWeather();



}
