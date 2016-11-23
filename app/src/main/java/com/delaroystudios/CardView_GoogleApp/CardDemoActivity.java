package com.delaroystudios.CardView_GoogleApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.delaroystudios.CardView_GoogleApp.Fragment.FragmentActivity;
import com.delaroystudios.CardView_GoogleApp.Network.NYTimesService;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.Recycler.RecyclerAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.delaroystudios.CardView_GoogleApp.Network.token.BASE_URL;


/**
 * Rafat Khandaker Maintaining Orthogonal standard of code
 **/

public class CardDemoActivity extends YouTubeBaseActivity {

    public static int positionClicked;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    List<Object> data = new ArrayList<>();

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        getTopStoriesClient();
        initCollapsingToolbar();

        data.add("place holder 1");
        data.add("place holder 2");
//        initiateRecyclerView();

    }

    //---------------------------------Recycler View Method----------------------------------------

    private void initiateRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(data);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    // -------------------------- ACTIVITY METHODS -------------------------------------------------

    public static void launchFragmentActivity(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }
//------------------------------------JOSIEL METHODS -----------------------------------------------

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Google Now");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);
        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("Google Now");
                    isShow = false;
                }
            }
        });
    }
    //------------------------------ GET VALUE METHODS ---------------------------------------------

    public static Integer getPositionClicked() {
        return positionClicked;
    }



    public void getTopStoriesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NYTimesService nyTimesService = retrofit.create(NYTimesService.class);
        Call<NYTopStoriesPOJO> getRecentMedia = nyTimesService.getTopStories();

        getRecentMedia.enqueue(new Callback<NYTopStoriesPOJO>() {
            @Override
            public void onResponse(Call<NYTopStoriesPOJO> call, Response<NYTopStoriesPOJO> response) {
                if (response.isSuccessful()) {
                    NYTopStoriesPOJO NYTTopStories = response.body();
                    Log.d("call:get results", "On response pass check: " + response.body().getResults().get(0).getTitle());
                    Log.d("call:get media", "On response check" + response.body().getResults().get(0).getMultimedia().get(0).getUrl());
                    Log.d("call:get status", "on response check" + response.body().getStatus());

                    //data = NYTTopStories.getResults();

                    List<NYTopStoriesPOJO.Results> results = NYTTopStories.getResults();
//                    List<NYTopStoriesPOJO.Multimedia> Multimedia = NYTTopStories.getResults().getMultimedia();
                        data.add(results.get(0));
//                        data.add(Multimedia.get(0));
//                    for (int i =0; i<results.size(); i++) {
//                        data.add(results.get(i));
//                    }
                    initiateRecyclerView();
                    //detailData = response.body().getResults().get(0).getTitle();
                }
            }

            @Override
            public void onFailure(Call<NYTopStoriesPOJO> call, Throwable t) {
                Log.d("call:fail ", "retrofit fail: " + t.toString());
            }
        });}

}