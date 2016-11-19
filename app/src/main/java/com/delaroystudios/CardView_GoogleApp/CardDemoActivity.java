package com.delaroystudios.CardView_GoogleApp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delaroystudios.CardView_GoogleApp.Network.NYTimesService;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.Recycler.RecyclerAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rafat Khandaker Maintaining Orthogonal standard of code
 * **/

public class CardDemoActivity extends YouTubeBaseActivity {

    public static final String BASE_URL = "https://api.nytimes.com/svc/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        initiateRecyclerView();
        serviceCallNYTimes();
        handleRecyclerView();
    }
     //---------------------------------Recycler View Method----------------------------------------

     private void initiateRecyclerView() {

         recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
         layoutManager = new LinearLayoutManager(this);
         adapter = new RecyclerAdapter();

                 recyclerView.setLayoutManager(layoutManager);
                 recyclerView.setAdapter(adapter);

             }
    //-------------------------------RETROFIT-------------------------------------------------------

    public void getTopStoriesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NYTimesService nyTimesService = retrofit.create(NYTimesService.class);
        Call<NYTopStoriesPOJO> getRecentMedia = nyTimesService.getTopStoriesJsonCall();
        getRecentMedia.enqueue(new Callback<NYTopStoriesPOJO>() {
            @Override
            public void onResponse(Call<NYTopStoriesPOJO> call, Response<NYTopStoriesPOJO> response) {
                if (response.isSuccessful()) {
                    NYTopStoriesPOJO NYTTopStories = response.body();
//                    .add(NYTTopStories);
                }
            }

            @Override
            public void onFailure(Call<NYTopStoriesPOJO> call, Throwable t) {
            }
        });
    }
    //-----------------------------Handle Service----------------------------------------------------------------
     private Boolean serviceCallNYTimes(){
         return new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 getTopStoriesClient();}
             }, 3000);
     }
     private Boolean handleRecyclerView(){
         return new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 initiateRecyclerView();
             }
         }, 3000);
     }


}
