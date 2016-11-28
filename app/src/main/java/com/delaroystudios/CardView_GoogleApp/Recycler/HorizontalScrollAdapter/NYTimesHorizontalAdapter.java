package com.delaroystudios.CardView_GoogleApp.Recycler.HorizontalScrollAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.NYTimesViewHolder;

import static com.delaroystudios.CardView_GoogleApp.MainActivity.nyTimesData;


/**
 * Created by RedDragon on 11/27/16.
 */

public class NYTimesHorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View nyView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.ny_times_card_layout, null);

        return new NYTimesViewHolder(nyView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ((NYTimesViewHolder) viewHolder).bind(((NYTopStoriesPOJO.Results)
                nyTimesData.get(position)));
    }

    @Override
    public int getItemCount() {
        return nyTimesData.size();
    }
}
