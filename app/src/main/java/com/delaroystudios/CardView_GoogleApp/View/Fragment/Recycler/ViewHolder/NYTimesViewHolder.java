package com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.delaroystudios.CardView_GoogleApp.Presentation.MainActivity.headerData;
import static com.delaroystudios.CardView_GoogleApp.Presentation.MainActivity.launchFragmentActivity;
import static com.delaroystudios.CardView_GoogleApp.Presentation.MainActivity.positionClicked;

/**
 * Created by RedDragon on 11/19/16.
 */

public class NYTimesViewHolder extends RecyclerView.ViewHolder {

    @Nullable @BindView(R.id.times_imageview) public ImageView timesImageView;
    @Nullable @BindView(R.id.times_detail_textview) public TextView timesDetailTextView;
    @Nullable @BindView(R.id.times_story_textview) public TextView timesStoryTextView;
    @Nullable @BindView(R.id.times_horizontal_recycler) public RecyclerView timesHorizontalRecyclerView;

    public static int horizontalPosition;

    public NYTimesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionClicked = 2;
                horizontalPosition = getAdapterPosition();

                Snackbar.make(v, "Click detected on item " + positionClicked,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // -------- LAUNCH FRAGMENT ACTIVITY ------------- //

                launchFragmentActivity(v.getContext());
            }
        });
    }
//----------------------------------Launch Web Browser----------------------------------------------

    /**  this is an unused method -- this method was used as a test to launch the
     * google chrome or default web browser application to extend the NY times card **/

    private void launchTimesWebUrl(Context context){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("http://www.google.com"));
        context.startActivity(browserIntent);

    }

//-----------------------------------Bind Method ---------------------------------------------------

    public void bind(NYTopStoriesPOJO.Results list){

        Random random = new Random();
        int imageCount = list.getMultimedia().size();

        timesStoryTextView.setText(list.getTitle());

        if(imageCount > 0) {
            int i = random.nextInt(list.getMultimedia().size());
            picassoMethod(list.getMultimedia().get(i).getUrl(),
                    timesImageView.getContext(), timesImageView);
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

    public Context getContext(){
        return timesHorizontalRecyclerView.getContext();
    }

}
