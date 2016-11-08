package com.delaroystudios.CardView_GoogleApp.Network;

/**
 * Created by RedDragon on 11/3/16.
 */

public class token {

    private static String Google_Key = "";   // use your key here Shawn*

    private static String NewYorkTimes_Key= "bbf0fecd74a24c42b50c9c6683575da7";

    private static String Sports_Key = "";  // use your key here Josiel*


    public static String getGoogle_Key(){
        return Google_Key;
    }

    public static String getNewYorkTimes_Key(){
        return NewYorkTimes_Key;
    }

    public static String getSports_Key(){ return Sports_Key; }

}
