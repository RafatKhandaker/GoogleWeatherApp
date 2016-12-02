package com.delaroystudios.CardView_GoogleApp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.delaroystudios.CardView_GoogleApp.MainActivity;
import com.delaroystudios.CardView_GoogleApp.R;

/**
 * Created by RedDragon on 11/8/16.
 */

public class FragmentActivity extends AppCompatActivity{

    private int checkLaunchValue = MainActivity.getPositionClicked();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        switch(checkLaunchValue){
            case 1:
                launchGoogleCalanderFragment();
                break;
            case 2:
                launchNewYorkTimesFragment();
                break;
            case 3:
                launchSportsFragment();
                break;
            default:
                break;
        }

    }




    private void launchNewYorkTimesFragment(){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NYTimesFragment NYTimesFrag = new NYTimesFragment();
        fragmentTransaction.add(R.id.fragment_container, NYTimesFrag);
        fragmentTransaction.commit();
    }

    private void launchGoogleCalanderFragment(){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        GoogleCalanderFragment googleFrag = new GoogleCalanderFragment();
        fragmentTransaction.add(R.id.fragment_container, googleFrag);
        fragmentTransaction.commit();
    }

    private void launchSportsFragment(){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SportsFragment sportsFrag = new SportsFragment();
        fragmentTransaction.add(R.id.fragment_container, sportsFrag);
        fragmentTransaction.commit();
    }
}
