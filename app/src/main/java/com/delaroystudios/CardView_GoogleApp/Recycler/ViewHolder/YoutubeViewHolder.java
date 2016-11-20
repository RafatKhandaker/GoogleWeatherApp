package com.delaroystudios.CardView_GoogleApp.Recycler.ViewHolder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.delaroystudios.CardView_GoogleApp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.launchFragmentActivity;
import static com.delaroystudios.CardView_GoogleApp.CardDemoActivity.positionClicked;

/**
 * Created by RedDragon on 11/19/16.
 */

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

//    @BindView(R.id.youtube_title_textview) public TextView youtubeTitleTextView;
//    @BindView(R.id.youtube_imageview) public ImageView youtubeImageView;
//    @BindView(R.id.youtube_detail_textview) public TextView youtubeDetailTextView;

    private static final String API_KEY = "AIzaSyAo4GrP1Cs1Q9TwWxMfNMj9DFnXkWh-5ps";
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

//    private static View inflate(ViewGroup parent) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        return layoutInflater.inflate(R.layout.youtube_card_layout, parent, false);
//    }

    public void bind() {
        final ArrayList<String> playlist_kanye = new ArrayList<>();
        playlist_kanye.add("m4w08DXtXn8");
        playlist_kanye.add("KXdQ8ZCzqkY");
        playlist_kanye.add("BUzyJANBjrM");
        playlist_kanye.add("p7FCgw_GlWc");
        playlist_kanye.add("3JUE6bs8neM");
        playlist_kanye.add("mzFFUADjA2k");
        playlist_kanye.add("PSpr4Mpo514");
        playlist_kanye.add("Dg-EYqQYqxE");
        playlist_kanye.add("Wmp-5cuOrIo");
        playlist_kanye.add("BDNxEvo_hMU");
        playlist_kanye.add("SMQP7QPN0bk");
        playlist_kanye.add("xGvm6btP1A");
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
                youTubePlayerView.initialize(API_KEY, onInitializedListener);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(API_KEY, onInitializedListener);
            }
        });
    }
}