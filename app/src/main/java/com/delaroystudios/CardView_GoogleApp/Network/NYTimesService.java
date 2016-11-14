package com.delaroystudios.CardView_GoogleApp.Network;

import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTimesSearchJSON;
import com.delaroystudios.CardView_GoogleApp.Network.ParseData.NYTopStoriesJSON;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by RedDragon on 11/13/16.
 */


// I Hi-Jacked this code from RUSILI for testing - RK

public interface NYTimesService {

    String topStoriesKey = "api-key=bbf0fecd74a24c42b50c9c6683575da7";
    String searchKey = "api-key=dba0adf3316748b6824798db63e90243";

    @GET("/svc/topstories/v1/home.json?" + topStoriesKey)
    Call<NYTopStoriesJSON> getTopStoriesJsonCall();

    @GET("/svc/search/v2/articlesearch.json?" + searchKey)
    Call<NYTimesSearchJSON> getSearchJsonCall();

}