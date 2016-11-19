package com.delaroystudios.CardView_GoogleApp.Recycler;

/**
 * Rafat K
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.delaroystudios.CardView_GoogleApp.R;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.GoogleViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.NYTimesViewHolder;
import com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder.YoutubeViewHolder;
import com.squareup.picasso.Picasso;


public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {


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
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        ViewHolder viewHolder;
        switch (i) {
            case 0:

                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.google_card_layout, viewGroup, false);
                viewHolder = new GoogleViewHolder(v);
                return viewHolder;


            case 1:

                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.youtube_card_layout, viewGroup, false);
                viewHolder = new YoutubeViewHolder(v);
                return viewHolder;


            case 2:

                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ny_times_card_layout, viewGroup, false);
                viewHolder = new NYTimesViewHolder(v);
                return viewHolder;

            default:
                Log.d("ERROR", "Failed to pass OnCreateViewHolder");
                break;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        View view =null;

        switch (i) {
            case 0:
                GoogleViewHolder googleViewHolder = (GoogleViewHolder) viewHolder;
                googleViewHolder.googleTitleTextView.setText(titles[i]);
                googleViewHolder.googleDetailTextView.setText(details[i]);
                googleViewHolder.googleImageView.setImageResource(images[i]);
                break;
            case 1:
//                YoutubeViewHolder youtubeViewHolder = (YoutubeViewHolder) viewHolder;
//                youtubeViewHolder.youtubeTitleTextView.setText(titles[i]);
//                youtubeViewHolder.youtubeDetailTextView.setText(details[i]);
//                youtubeViewHolder.youtubeImageView.setImageResource(images[i]);
                break;
            case 2:
//                NYTimesViewHolder timesViewHolder = (NYTimesViewHolder) viewHolder;
//                timesViewHolder.timesTitleTextView.setText(titles[i]);
//                timesViewHolder.timesDetailTextView.setText(details[i]);
//                picassoMethod((CardDemoActivity.BASE_URL), viewHolder.timesImageView.getContext(), viewHolder.timesImageView );

                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    private static void picassoMethod(String url, Context context, ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .resize(300, 300)
                .centerCrop()
                .into(imageView);
    }
}