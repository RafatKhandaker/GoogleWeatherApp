package com.delaroystudios.CardView_GoogleApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Rafat Khandaker Maintaining Orthogonal standard of code
 * **/

public class CardDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        initiateRecyclerView(recyclerView, layoutManager, adapter);

    }
     //---------------------------------Recycler View Method----------------------------------------

     public void initiateRecyclerView
             (RecyclerView x, RecyclerView.LayoutManager y, RecyclerView.Adapter z)
     {

         x = (RecyclerView) findViewById(R.id.recycler_view);

         y = new LinearLayoutManager(this);
         x.setLayoutManager(y);

         z = new RecyclerAdapter();
         x.setAdapter(z);

     }
     //---------------------------------------------------------------------------------------------
}
