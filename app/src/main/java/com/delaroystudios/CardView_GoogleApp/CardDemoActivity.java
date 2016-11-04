package com.delaroystudios.CardView_GoogleApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Rafat K
 * **/

public class CardDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        initiateRecyclerView();

    }
     //---------------------------------Recycler View ----------------------------------------------

     public void initiateRecyclerView (){

         recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

         layoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(layoutManager);

         adapter = new RecyclerAdapter();
         recyclerView.setAdapter(adapter);

     }
     //---------------------------------------------------------------------------------------------
}
