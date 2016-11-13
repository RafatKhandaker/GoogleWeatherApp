package com.delaroystudios.CardView_GoogleApp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Arrays;
import java.util.List;

public class YouTubeViewHolder extends RecyclerView.ViewHolder implements GoogleNowCard {

    private YouTubePlayer.OnInitializedListener onInitializedListener;

    private final View view;
    private YouTubePlayerView youTubePlayerView;
    private Button button;

    public YouTubeViewHolder(ViewGroup parent) {
        super(inflate(parent));
        view = itemView;
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        button = (Button) view.findViewById(R.id.play_button);
    }

    private static View inflate(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return layoutInflater.inflate(R.layout.youtube_activity, parent, false);
    }

    public void bind(GoogleNowCard nowCard) {

//        List<String> playlist = Arrays.asList(
//                Arrays.asList("KT7W9oJP6BI", "KXdQ8ZCzqkY", "BUzyJANBjrM")
//        );

        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("KT7W9oJP6BI");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        button = (Button) view.findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyAo4GrP1Cs1Q9TwWxMfNMj9DFnXkWh-5ps", onInitializedListener);
            }
        });
    }
}
