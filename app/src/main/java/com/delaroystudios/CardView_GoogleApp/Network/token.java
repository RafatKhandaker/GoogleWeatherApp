package com.delaroystudios.CardView_GoogleApp.Network;

/**
 * Created by RedDragon on 11/3/16.
 */

public class token {

    public static final String BASE_URL = "https://api.nytimes.com/svc/";


    public static String Google_Key = "";   // use your key here Shawn*
    public static String NewYorkTimes_Key= "bbf0fecd74a24c42b50c9c6683575da7";
    public static final String YOUTUBE_KEY = "AIzaSyAo4GrP1Cs1Q9TwWxMfNMj9DFnXkWh-5ps";




    public static String getGoogle_Key(){
        return Google_Key;
    }

    public static String getNewYorkTimes_Key(){
        return NewYorkTimes_Key;
    }

    public static String getYoutubeKey(){ return YOUTUBE_KEY; }

}
