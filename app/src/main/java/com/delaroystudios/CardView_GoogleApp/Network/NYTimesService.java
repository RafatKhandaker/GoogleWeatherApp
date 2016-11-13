package com.delaroystudios.CardView_GoogleApp.Network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RedDragon on 11/13/16.
 */


// I Hi-Jacked this code from RUSILI for testing - RK
public interface NYTimesService {

    String BestSellersAPIKEY = "api-key=d28cb3126eae332c6279f9dedf4bb830%3A10%3A64325990";
    String TopStoriesAPIKEY = "api-key=5e44b56b643a4186b68ac48ded3608a8";

//    @GET("books/v3/lists/best-sellers/historyjson?" + BestSellersAPIKEY)
//    Call<BestSeller> getBestSellers();
//
//    @GET("topstories/v2/home.json?" + TopStoriesAPIKEY)
//    Call<TopStory> getTopStories();
}
