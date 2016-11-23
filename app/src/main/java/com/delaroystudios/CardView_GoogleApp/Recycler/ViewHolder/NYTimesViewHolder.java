package com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.launchFragmentActivity;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.positionClicked;

/**
 * Created by RedDragon on 11/19/16.
 */

public class NYTimesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.times_title_textview) public TextView timesTitleTextView;
    @BindView(R.id.times_imageview) public ImageView timesImageView;
    @BindView(R.id.times_detail_textview) public TextView timesDetailTextView;


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
        //, Multimedia list2
        timesTitleTextView.setText(list.getTitle());
//        picassoMethod(list2.getUrl(), timesImageView.getContext(), timesImageView);
    }

    private static void picassoMethod(String url, Context context, ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .resize(300, 300)
                .centerCrop()
                .into(imageView);
    }


}
