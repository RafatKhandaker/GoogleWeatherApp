package com.delaroystudios.CardView_GoogleApp.Recycler;

/**
 * Rafat K
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.delaroystudios.CardView_GoogleApp.R;


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
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}