package com.delaroystudios.CardView_GoogleApp.Network;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimesSearchJSON;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesJSON;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by RedDragon on 11/13/16.
 */


public interface NYTimesService {

    String topStoriesKey = "api-key=bbf0fecd74a24c42b50c9c6683575da7";
    String searchKey = "api-key=dba0adf3316748b6824798db63e90243";
    public static String qParameter = "";

    @GET("/svc/topstories/v1/home.json?" + topStoriesKey)
    Call<NYTopStoriesJSON> getTopStoriesJsonCall();

    @GET("/svc/search/v2/articlesearch.json?" +searchKey + "q=" +qParameter)
    Call<NYTimesSearchJSON> getSearchJsonCall();

    // querry for search key use parameter q

}