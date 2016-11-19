package com.delaroystudios.CardView_GoogleApp.Recycler;

/**
 * Rafat K
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.delaroystudios.CardView_GoogleApp.CardDemoActivity;
import com.delaroystudios.CardView_GoogleApp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;


public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    @BindView(R.id.google_title_textview) TextView googleTitleTextView;
    @BindView (R.id.youtube_title_textview) TextView youtubeTitleTextView;
    @BindView (R.id.times_title_textview) TextView timesTitleTextView;

    @BindView (R.id.google_imageview) ImageView googleImageView;
    @BindView (R.id.youtube_imageview) ImageView youtubeImageView;
    @BindView (R.id.times_imageview) ImageView timesImageView;

    @BindView (R.id.google_detail_textview) TextView googleDetailTextView;
    @BindView (R.id.youtube_detail_textview) TextView youtubeDetailTextView;
    @BindView (R.id.times_detail_textview) TextView timesDetailTextView;

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
        switch(i) {
            case 0:

                 v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.google_card_layout, viewGroup, false);
                viewHolder = new ViewHolder(v);
                return viewHolder;


            case 1:

                 v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.youtube_card_layout, viewGroup, false);
                 viewHolder = new ViewHolder(v);
                return viewHolder;


            case 2:

                v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ny_times_card_layout, viewGroup, false);
                viewHolder = new ViewHolder(v);
                return viewHolder;

            default:
                Log.d("ERROR", "Failed to pass OnCreateViewHolder");
    break;

}
return null;
        }

@Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        switch(i) {
            case 0:
                googleTitleTextView.setText(titles[i]);
                googleDetailTextView.setText(details[i]);
                googleImageView.setImageResource(images[i]);
                break;
            case 1:
                youtubeTitleTextView.setText(titles[i]);
                youtubeDetailTextView.setText(details[i]);
                youtubeImageView.setImageResource(images[i]);
                break;
            case 2:
                timesTitleTextView.setText(titles[i]);
                timesDetailTextView.setText(details[i]);
                picassoMethod((CardDemoActivity.BASE_URL), timesImageView.getContext(), timesImageView );

                break;
            default:
                break;
        }
}

    @Override
    public int getItemCount() {
        return titles.length;
    }

    private static void picassoMethod(String url, Context context, ImageView imageView){
        Picasso.with(context)
                .load(url)
                .resize(300, 300)
                .centerCrop()
                .into(imageView);
    }
}