package com.delaroystudios.CardView_GoogleApp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delaroystudios.CardView_GoogleApp.Network.NYTimesService;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesJSON;
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

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        initiateRecyclerView();

    }
     //---------------------------------Recycler View Method----------------------------------------

     public void initiateRecyclerView() {

         recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
         layoutManager = new LinearLayoutManager(this);
         adapter = new RecyclerAdapter();

         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);

     }
     //---------------------------------------------------------------------------------------------

     public void topStoriesAPI() {
         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("https://api.nytimes.com")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         NYTimesService nyTimesService = retrofit.create(NYTimesService.class);
         Call<NYTopStoriesJSON> getRecentMedia = nyTimesService.getTopStoriesJsonCall();
         getRecentMedia.enqueue(new Callback<NYTopStoriesJSON>() {
             @Override
             public void onResponse(Call<NYTopStoriesJSON> call, Response<NYTopStoriesJSON> response) {
                 if (response.isSuccessful()) {
                     NYTopStoriesJSON nyTopStories = response.body();
//                     .add(NYTTopStories);
                 }
             }

             @Override
             public void onFailure(Call<NYTopStoriesJSON> call, Throwable t) {

             }

         });
     }

}
