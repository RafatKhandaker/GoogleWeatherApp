package com.delaroystudios.CardView_GoogleApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.delaroystudios.CardView_GoogleApp.Fragment.FragmentActivity;
import com.delaroystudios.CardView_GoogleApp.Network.NYTimesService;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesPOJO;
import com.delaroystudios.CardView_GoogleApp.Recycler.RecyclerAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rafat Khandaker Maintaining Orthogonal standard of code
 * **/

public class CardDemoActivity extends YouTubeBaseActivity {

    public static List<Object> retroData;
    public static final String BASE_URL = "https://api.nytimes.com/svc/";
    public static int positionClicked;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

//    private TextView mOutputText;
//    private Button mCallApiButton;
//    ProgressDialog mProgress;
//
//    static final int REQUEST_ACCOUNT_PICKER = 1000;
//    static final int REQUEST_AUTHORIZATION = 1001;
//    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
//    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        initiateRecyclerView();
        initCollapsingToolbar();
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
        Call<NYTopStoriesPOJO> getRecentMedia = nyTimesService.getTopStories();
        getRecentMedia.enqueue(new Callback<NYTopStoriesPOJO>() {
            @Override
            public void onResponse(Call<NYTopStoriesPOJO> call, Response<NYTopStoriesPOJO> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse:", "On response pass check");
                    NYTopStoriesPOJO NYTTopStories = response.body();
//                    retroData.add(NYTTopStories);
                }
            }

            @Override
            public void onFailure(Call<NYTopStoriesPOJO> call, Throwable t) {
                Log.d("On Failure", "retrofit fail");
//                retroData.add(0);
            }
        });
    }
    //-----------------------------Handle Service---------------------------------------------------

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

    public static Integer getPositionClicked(){
        return positionClicked;
    }

}
