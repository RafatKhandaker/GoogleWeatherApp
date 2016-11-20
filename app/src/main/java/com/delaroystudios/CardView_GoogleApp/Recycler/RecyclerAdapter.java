package com.delaroystudios.CardView_GoogleApp.Recycler;

/**
 * Rafat K
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.GoogleViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.NYTimesViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.YoutubeViewHolder;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.retroData;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private String[] titles = {
            "Google Calander API",
            "Sports Update API",
            "New York Times API",
    };

    private String[] details = {
            "Description",
            "Description",
            "Description"
    };

    private int[] images = {
            R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
    };


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        RecyclerView.ViewHolder viewHolder = null;

        switch (i) {
            case 0:
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.google_card_layout, viewGroup, false);
                viewHolder = new GoogleViewHolder(v);
                break;
            case 1:
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.youtube_card_layout, viewGroup, false);
                viewHolder = new YoutubeViewHolder(v);
                break;
            case 2:
                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ny_times_card_layout, viewGroup, false);
                viewHolder = new NYTimesViewHolder(v);
            default:
                Log.d("ERROR", "Failed to pass OnCreateViewHolder");
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        switch (i) {
            case 0:
                GoogleViewHolder googleViewHolder = (GoogleViewHolder) viewHolder;
                googleViewHolder.googleTitleTextView.setText(titles[i]);
                googleViewHolder.googleDetailTextView.setText(details[i]);
                googleViewHolder.googleImageView.setImageResource(images[i]);

                break;
            case 1:
                YoutubeViewHolder youtubeViewHolder = (YoutubeViewHolder) viewHolder;
                youtubeViewHolder.bind();
                break;

            case 2:
                NYTimesViewHolder timesViewHolder = (NYTimesViewHolder) viewHolder;
//                timesViewHolder.bind((NYTopStoriesPOJO) retroData.get(0));

                break;
            default:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch(position){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                break;

        }
        return -1;
    }


    @Override
    public int getItemCount() {
        return titles.length;
    }



}
