package com.delaroystudios.CardView_GoogleApp;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private final int YOUTUBE = 0;

    private List<YouTubeCard> googleList = Arrays.asList(
            new YouTubeCard(),
            new YouTubeCard(),
            new YouTubeCard(),
            new YouTubeCard(),
            new YouTubeCard(),
            new YouTubeCard(),
            new YouTubeCard()
    );

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case YOUTUBE:
                viewHolder = new YouTubeViewHolder(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case YOUTUBE:
                YouTubeViewHolder youTubeViewHolder = (YouTubeViewHolder) holder;
                youTubeViewHolder.bind();
        }
    }

    @Override
    public int getItemCount() {
        return googleList.size();
    }

}
