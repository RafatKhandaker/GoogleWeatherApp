package com.delaroystudios.CardView_GoogleApp.Model.Network;

import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.NYTimes.NYTimesSearchPOJO;
import com.delaroystudios.CardView_GoogleApp.Model.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RedDragon on 11/13/16.
 */


public interface NYTimesService {

    String qParameter = "";

    @GET("topstories/v2/home.json?" + token.timesTopStoriesKey)
    Call<NYTopStoriesPOJO> getTopStories();

    @GET("search/v2/articlesearch.json?" +token.timesSearchKey + "q=" +qParameter)
    Call<NYTimesSearchPOJO> getSearchJsonCall();

}