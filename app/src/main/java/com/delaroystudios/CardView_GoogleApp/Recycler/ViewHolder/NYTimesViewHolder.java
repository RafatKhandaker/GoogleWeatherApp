package com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.headerData;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.launchFragmentActivity;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.positionClicked;

/**
 * Created by RedDragon on 11/19/16.
 */

public class NYTimesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.times_title_textview) public TextView timesTitleTextView;
    @BindView(R.id.times_imageview) public ImageView timesImageView;
    @BindView(R.id.times_detail_textview) public TextView timesDetailTextView;
    @BindView(R.id.times_story_textview) public TextView timesStoryTextView;


    public NYTimesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionClicked = getAdapterPosition()+1;

                Snackbar.make(v, "Click detected on item " + positionClicked,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // -------- LAUNCH FRAGMENT ACTIVITY ------------- //
                launchFragmentActivity(v.getContext());
            }
        });
    }

    //-------------------------------RETROFIT-------------------------------------------------------


//--------------------------------------------------------------------------------------------------

    public void bind(NYTopStoriesPOJO.Results list){

        Random random = new Random();
        int imageCount = list.getMultimedia().size();

        timesStoryTextView.setText(list.getTitle());

        if(imageCount > 0) {
            int i = random.nextInt(list.getMultimedia().size());
            picassoMethod(list.getMultimedia().get(i).getUrl(), timesImageView.getContext(), timesImageView);
        }else{
            timesImageView.setImageResource(R.drawable.news);
        }

        timesDetailTextView.setText(headerData.get(0));
    }

    private static void picassoMethod(String url, Context context, ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .resize(400, 400)
                .centerCrop()
                .into(imageView);
    }


}
