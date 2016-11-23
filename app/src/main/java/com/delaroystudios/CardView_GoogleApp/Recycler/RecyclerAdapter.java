package com.delaroystudios.CardView_GoogleApp.Recycler;

/**
 * Rafat K
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.GoogleViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.NYTimesViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.YoutubeViewHolder;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int GOOGLE_TYPE = 0, YOUTUBE_TYPE = 1, NY_TIMES_TYPE = 2;
    List<Object> data;

    public RecyclerAdapter(List<Object> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            switch (viewType) {

            case GOOGLE_TYPE:
                View googleView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.google_card_layout, null);
                return new GoogleViewHolder(googleView);

            case YOUTUBE_TYPE:
                View youtubeView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.youtube_card_layout, null);
                return new YoutubeViewHolder(youtubeView);

            case NY_TIMES_TYPE:
                View nyView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ny_times_card_layout, null);
                return new NYTimesViewHolder(nyView);

            default:
                Log.d("ERROR", "Failed to pass OnCreateViewHolder");
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        final int itemType = getItemViewType(i);

//        if (itemType == GOOGLE_TYPE){
//            ((GoogleViewHolder) viewHolder).bind() data.get(i);
//        }

        if (itemType == NY_TIMES_TYPE) {
            ((NYTimesViewHolder) viewHolder).bind(((NYTopStoriesPOJO.Results) data.get(2)));
            //,(Multimedia) data.get(3)
        }
    }



    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return GOOGLE_TYPE;
        }
        if (position == 1){
            return YOUTUBE_TYPE;
        }
        if (data.get(position) instanceof NYTopStoriesPOJO.Results){
            return NY_TIMES_TYPE;
        }

//        switch(position){
//            case 0:
//                return 0;
//            case 1:
//                return 1;
//            case 2:
//                return 2;
//            default:
//                break;
//        }
        return -1;
    }


    @Override
    public int getItemCount() {
//        return data.size();
        return 3;
    }



}
