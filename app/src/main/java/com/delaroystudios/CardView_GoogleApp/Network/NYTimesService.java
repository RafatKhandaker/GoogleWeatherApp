package com.delaroystudios.CardView_GoogleApp.Network;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTimesSearchPOJO;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimes.NYTopStoriesPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RedDragon on 11/13/16.
 */

public interface NYTimesService {


    String topStoriesKey = "api-key=bbf0fecd74a24c42b50c9c6683575da7";
    String searchKey = "api-key=dba0adf3316748b6824798db63e90243";
    public static String qParameter = "";

    @GET("topstories/v2/home.json?" + topStoriesKey)
    Call<NYTopStoriesPOJO> getTopStories();

    @GET("search/v2/articlesearch.json?" +searchKey + "q=" +qParameter)
    Call<NYTimesSearchPOJO> getSearchJsonCall();

    // querry for search key use parameter q

}