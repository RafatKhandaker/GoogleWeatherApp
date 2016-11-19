package com.delaroystudios.CardView_GoogleApp.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.CardView_GoogleApp.Fragment.FragmentActivity;
import com.delaroystudios.CardView_GoogleApp.R;

import butterknife.BindView;

/**
 * Created by RedDragon on 11/4/16.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    public static int positionClicked;

    public ViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionClicked = getAdapterPosition()+1;

                Snackbar.make(v, "Click detected on item " + positionClicked,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // -------- LAUNCH FRAGMENT ACTIVITY ------------- //
                launchFragmentActivity(v.getContext());
            }
        });
    }

    // -------------------------- ACTIVITY METHODS -------------------------------------------------

    public void launchFragmentActivity(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }

    //------------------------------ GET VALUE METHODS ---------------------------------------------

    public static Integer getPositionClicked(){ return positionClicked;}


}
