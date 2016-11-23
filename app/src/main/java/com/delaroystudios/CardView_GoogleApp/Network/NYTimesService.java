package com.delaroystudios.CardView_GoogleApp.Network;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTimesSearchPOJO;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RedDragon on 11/13/16.
 */

public interface NYTimesService {

    // querry for search key use parameter q

    String qParameter = "";

    @GET("topstories/v2/home.json?" + token.timesTopStoriesKey)
    Call<NYTopStoriesPOJO> getTopStories();

    @GET("search/v2/articlesearch.json?" +token.timesSearchKey + "q=" +qParameter)
    Call<NYTimesSearchPOJO> getSearchJsonCall();


}