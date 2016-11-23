package com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.Button;

import com.delaroystudios.CardView_GoogleApp.Network.token;
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
    private Button button2;

    public YoutubeViewHolder(View parent) {
        super(parent);
        view = itemView;
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        button = (Button) view.findViewById(R.id.play_kanye);
        button2 = (Button) view.findViewById(R.id.play_drake);
    }


    public void bind() {
        final ArrayList<String> playlist_kanye = new ArrayList<>();

        playlist_kanye.add("BoEKWtgJQAU");
        playlist_kanye.add("Bm5iA4Zupek");
        playlist_kanye.add("8kyWDhB_QeI");
        playlist_kanye.add("PsO6ZnUZI0g");
        playlist_kanye.add("L53gjP-TtGE");
        playlist_kanye.add("Dqgr0wNyPo");
        playlist_kanye.add("q604eed4ad0");
        final ArrayList<String> playlist_drake = new ArrayList<>();
        playlist_drake.add("RubBzkZzpUA");
        playlist_drake.add("uxpDa-c-4Mc");
        playlist_drake.add("7LnBvuzjpr4");
        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideos(playlist_kanye);
                youTubePlayer.loadVideos(playlist_drake);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        button = (Button) view.findViewById(R.id.play_kanye);
        button2 = (Button) view.findViewById(R.id.play_drake);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(token.getYoutubeKey(), onInitializedListener);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(token.getYoutubeKey(), onInitializedListener);
            }
        });
    }
}