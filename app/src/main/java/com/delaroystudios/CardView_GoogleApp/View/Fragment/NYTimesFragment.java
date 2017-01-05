package com.delaroystudios.CardView_GoogleApp.View.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.delaroystudios.CardView_GoogleApp.R;

import java.util.List;

import static com.delaroystudios.CardView_GoogleApp.MainActivity.uriData;
import static com.delaroystudios.CardView_GoogleApp.View.Fragment.Recycler.ViewHolder.NYTimesViewHolder.horizontalPosition;

/**
 * Created by RedDragon on 11/8/16.
 */

public class NYTimesFragment extends Fragment {

    WebView timesWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View timesViewFragment = inflater.inflate(R.layout.ny_times_fragment, container, false);

        loadUriPage(timesViewFragment, uriData);

        return timesViewFragment;
    }


    public void loadUriPage(View v, List<String> list){

        timesWebView = (WebView) v.findViewById(R.id.times_web_view);
        timesWebView.loadUrl(list.get(horizontalPosition));
        WebSettings webSettings = timesWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        timesWebView.setWebViewClient(new WebViewClient());
    }
}
