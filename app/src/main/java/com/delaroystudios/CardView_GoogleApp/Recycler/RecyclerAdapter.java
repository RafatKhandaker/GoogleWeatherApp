package com.delaroystudios.CardView_GoogleApp.Recycler;

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
import com.delaroystudios.CardView_GoogleApp.Recycler.HorizontalScrollAdapter.NYTimesHorizontalAdapter;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.GoogleViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.NYTimesViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.YoutubeViewHolder;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private static final int GOOGLE_TYPE = 0, NY_TIMES_TYPE = 1, YOUTUBE_TYPE = 2 ;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            switch (viewType) {

            case GOOGLE_TYPE:
                View googleView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.google_card_layout, null);
                return new GoogleViewHolder(googleView);

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

        if (itemType == GOOGLE_TYPE){
            ((GoogleViewHolder) viewHolder).bind();
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
            case GOOGLE_TYPE: return GOOGLE_TYPE;

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
