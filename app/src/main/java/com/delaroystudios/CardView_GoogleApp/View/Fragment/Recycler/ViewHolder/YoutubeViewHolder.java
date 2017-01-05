package com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.Button;

import com.delaroystudios.CardView_GoogleApp.Model.Network.token;
import com.delaroystudios.CardView_GoogleApp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

/**
 * Created by RedDragon on 11/19/16.
 */

public class YoutubeViewHolder extends RecyclerView.ViewHolder {


    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private final View view;
    private YouTubePlayerView youTubePlayerView;
    private Button button;


    public YoutubeViewHolder(View parent) {
        super(parent);
        view = itemView;
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        button = (Button) view.findViewById(R.id.play_button);

    }


    public void bind() {
        final ArrayList<String> playlist = new ArrayList<>();

        playlist.add("BoEKWtgJQAU");
        playlist.add("Bm5iA4Zupek");
        playlist.add("8kyWDhB_QeI");
        playlist.add("PsO6ZnUZI0g");
        playlist.add("L53gjP-TtGE");
        playlist.add("Dqgr0wNyPo");
        playlist.add("q604eed4ad0");
        playlist.add("RubBzkZzpUA");
        playlist.add("uxpDa-c-4Mc");
        playlist.add("7LnBvuzjpr4");

        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideos(playlist);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        button = (Button) view.findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(token.YOUTUBE_KEY, onInitializedListener);
            }
        });

    }
}