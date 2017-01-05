package com.delaroystudios.CardView_GoogleApp.Presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.delaroystudios.CardView_GoogleApp.Model.Network.NYTimesService;
import com.delaroystudios.CardView_GoogleApp.Model.Network.OpenWeatherService;
import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.OpenWeather.OpenWeatherPOJO;
import com.delaroystudios.CardView_GoogleApp.Model.Network.token;
import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.FragmentActivity;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.RecyclerAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**************************************************************************************************\
 ***************** Rafat Khandaker Maintaining Orthogonal standard of code *************************
 \*************************************************************************************************/

public class MainActivity extends YouTubeBaseActivity {

    public static int positionClicked;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public static List<Object> nyTimesData = new ArrayList<>();
    public static List<String> headerData = new ArrayList<>();
    public static List<String> uriData = new ArrayList<>();

    public static List<Object> mainWeatherData = new ArrayList<>();
    public static List<Object> lowTempWeatherData = new ArrayList<>();
    public static List<Object> highTempWeatherData = new ArrayList<>();
    public static List<Double> currentTempWeatherData = new ArrayList<>();
    public static List<Object> currentHumidityWeatherData = new ArrayList<>();
    public static List<Object> windSpeedWeatherData = new ArrayList<>();
    public static List<Object> dateWeatherData = new ArrayList<>();
    public static HashMap<String, Integer> setIcon = new HashMap<>();

    public static String currentDateTimeString;

//--------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentDateTimeString = "";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            currentDateTimeString = android.icu.text.DateFormat
                    .getDateTimeInstance().format(new Date());
        }

        setContentView(R.layout.main_activity_layout);
        initCollapsingToolbar();

        getWeatherClient();
        getTopStoriesClient();
    }

//------------------------------------Recycler View Method------------------------------------------

    private void initiateRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

// ------------------------------ ACTIVITY METHODS -------------------------------------------------

    public static void launchFragmentActivity(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }

//------------------------------------JOSIEL METHODS -----------------------------------------------

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Google Now");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("Google Now");
                    isShow = false;
                }
            }
        });
    }

//---------------------------------- GET VALUE METHODS ---------------------------------------------

    public static Integer getPositionClicked() {
        return positionClicked;
    }


//----------------------------------- Retrofit Data ------------------------------------------------

    /** NY York Times Data **/

    public void getTopStoriesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(token.NEW_YORK_TIMES_TOPSTORY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NYTimesService nyTimesService = retrofit.create(NYTimesService.class);
        Call<NYTopStoriesPOJO> getRecentMedia = nyTimesService.getTopStories();

        getRecentMedia.enqueue(new Callback<NYTopStoriesPOJO>() {
            @Override
            public void onResponse(Call<NYTopStoriesPOJO> call, Response<NYTopStoriesPOJO> response) {
                if (response.isSuccessful()) {
                    NYTopStoriesPOJO NYTTopStories = response.body();
                     List<NYTopStoriesPOJO.Results> results = NYTTopStories.getResults();

                    for (int i = 0; i<results.size(); i++) {
                        nyTimesData.add(results.get(i));
                        headerData.add(response.body().getLast_updated());
                        uriData.add(response.body().getResults().get(i).getUrl());
                    }

                    initiateRecyclerView();

                }
            }

            @Override
            public void onFailure(Call<NYTopStoriesPOJO> call, Throwable t) {
                Log.d("call:fail ", "retrofit fail: " + t.toString());
            }
        });}


    /** Open Weather Data  **/

    public void getWeatherClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(token.OPEN_WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherService openWeatherService = retrofit.create(OpenWeatherService.class);
        Call<OpenWeatherPOJO> getWeatherCall = openWeatherService.getOpenWeather();

        getWeatherCall.enqueue(new Callback<OpenWeatherPOJO>() {
            @Override
            public void onResponse(Call<OpenWeatherPOJO> call, Response<OpenWeatherPOJO> response) {
                OpenWeatherPOJO openWeather = response.body();

                Log.d("On Response", "Weather: " +response.body().getList().get(0).getMain().getTemp());
                for(int i = 0; i < openWeather.getList().size() ; i++){

                    // converted data from kelvin to farenheight/ meter per second to miles per hour
                    currentTempWeatherData.add(((9/5)*openWeather.getList().get(i)
                            .getMain().getTemp() - 273)+32);

                    lowTempWeatherData.add(((9/5)*openWeather.getList().get(i)
                            .getMain().getTempMin() - 273)+32);

                    highTempWeatherData.add(((9/5)*(openWeather.getList().get(i)
                            .getMain().getTempMax() - 273))+32);

                    windSpeedWeatherData.add(openWeather.getList().get(i).getWind()
                            .getSpeed() *2.23694); // mph

                    mainWeatherData.add(openWeather.getList().get(i).getWeather().get(0).getMain());

                    currentHumidityWeatherData.add(openWeather.getList().get(i).getMain()
                            .getHumidity());
                    dateWeatherData.add(openWeather.getList().get(i).getDtTxt());

                    Log.d("weather data main", " weather: " +mainWeatherData);

                    Log.d("On Response", "temp: " +currentTempWeatherData.get(i));

                    Log.d("On Response", "Wind: " +windSpeedWeatherData.get(i));

                    Log.d("On Response", "date Text: " +dateWeatherData.get(i));

                    createIconSet();
                }

            }

            @Override
            public void onFailure(Call<OpenWeatherPOJO> call, Throwable t) {
                Log.d("call:fail ", "retrofit fail: " + t.toString());
            }
        });
    }

//---------------------------------private method used in retrofit ---------------------------------
    private void createIconSet(){
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        setIcon.put("Clear_Morning", R.drawable.clear_sky_sunny);
        setIcon.put("Clear_Night", R.drawable.clear_night);
        setIcon.put("Clear", R.drawable.clear_sky_sunny);
        setIcon.put("Snow_Sunny", R.drawable.sunny_snow);
        setIcon.put("Snow_Night", R.drawable.night_snow);
        setIcon.put("Snow", R.drawable.snow);
        setIcon.put("Rain", R.drawable.rain);
        setIcon.put("Sun_Shower", R.drawable.sunny_thunder_storm_rain);
        setIcon.put("Rain_Night", R.drawable.night_thunderstorm_rain);
        setIcon.put("Clouds", R.drawable.cloudy);
        setIcon.put("Cloudy_Morning", R.drawable.sunny_cloudy);
        setIcon.put("Cloudy_Night", R.drawable.night_cloudy);
    }

}