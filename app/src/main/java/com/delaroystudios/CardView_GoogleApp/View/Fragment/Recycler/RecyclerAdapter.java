package com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler;

/**
 * Rafat K
 */

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.HorizontalScrollAdapter.NYTimesHorizontalAdapter;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.HorizontalScrollAdapter.WeatherHorizontalAdapter;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder.NYTimesViewHolder;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder.WeatherViewHolder;
import com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder.YoutubeViewHolder;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int WEATHER_TYPE = 0, NY_TIMES_TYPE = 1, YOUTUBE_TYPE = 2 ;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            switch (viewType) {

            case WEATHER_TYPE:
                View weatherView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.open_weather_recycler_viewholder, null);
                return new WeatherViewHolder(weatherView);

            case NY_TIMES_TYPE:
                View nyView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ny_times_recycler_viewholder, null);
                return new NYTimesViewHolder(nyView);

            case YOUTUBE_TYPE:
                View youtubeView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.youtube_card_layout, null);
                return new YoutubeViewHolder(youtubeView);

            default:
                Log.d("ERROR", "Failed to pass OnCreateViewHolder");
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        final int itemType = getItemViewType(i);

        if (itemType == WEATHER_TYPE){

            WeatherHorizontalAdapter weatherHorizontalAdapter = new WeatherHorizontalAdapter();
            ((WeatherViewHolder) viewHolder).weatherHorizontalRecyclerView.setLayoutManager(
                    new LinearLayoutManager(((WeatherViewHolder) viewHolder).getContext(),
                    LinearLayoutManager.HORIZONTAL, false));

            ((WeatherViewHolder) viewHolder).weatherHorizontalRecyclerView
                    .setAdapter(weatherHorizontalAdapter);
            ((WeatherViewHolder) viewHolder).weatherHorizontalRecyclerView
                    .setNestedScrollingEnabled(false);
            weatherHorizontalAdapter.notifyDataSetChanged();

        }

        if (itemType == NY_TIMES_TYPE) {

            NYTimesHorizontalAdapter timesHorizontalAdapter = new NYTimesHorizontalAdapter();
            ((NYTimesViewHolder) viewHolder).timesHorizontalRecyclerView.setLayoutManager(
                    new LinearLayoutManager(((NYTimesViewHolder) viewHolder).getContext(),
                            LinearLayoutManager.HORIZONTAL, false));
            ((NYTimesViewHolder) viewHolder).timesHorizontalRecyclerView
                    .setAdapter(timesHorizontalAdapter);
            ((NYTimesViewHolder) viewHolder).timesHorizontalRecyclerView
                    .setNestedScrollingEnabled(false);
            timesHorizontalAdapter.notifyDataSetChanged();
        }

        if (itemType == YOUTUBE_TYPE){
            ((YoutubeViewHolder) viewHolder).bind();
        }

    }

      @Override
    public int getItemViewType(int position) {
        switch(position){
            case WEATHER_TYPE: return WEATHER_TYPE;

            case NY_TIMES_TYPE: return NY_TIMES_TYPE;

            case YOUTUBE_TYPE: return YOUTUBE_TYPE;

        }
        return -1;
    }


    @Override
    public int getItemCount() {
        return 3;
    }

}
