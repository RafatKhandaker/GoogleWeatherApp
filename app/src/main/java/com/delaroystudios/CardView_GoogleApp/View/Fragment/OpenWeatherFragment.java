package com.delaroystudios.CardView_GoogleApp.View.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.CardView_GoogleApp.R;


/**
 * Created by RedDragon on 11/8/16.
 */

public class OpenWeatherFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.open_weather_fragment, container, false);
    }
}

