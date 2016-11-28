package com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.delaroystudios.CardView_GoogleApp.MainActivity.launchFragmentActivity;
import static com.delaroystudios.CardView_GoogleApp.MainActivity.positionClicked;

/**
 * Created by RedDragon on 11/19/16.
 */

public class GoogleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.google_title_textview) public TextView googleTitleTextView;
    @BindView(R.id.google_imageview) public ImageView googleImageView;
    @BindView(R.id.google_detail_textview) public TextView googleDetailTextView;

    public GoogleViewHolder(View itemView) {
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

    public void bind(){
        googleTitleTextView.setText("Google Calander Card");
        googleImageView.setImageResource(R.drawable.images);
    }

}
