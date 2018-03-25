package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the viewpager that will allow the user to move through fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //create adapter that will handle to show the right windows
        TourFragmentPagerAdapter mAdapter = new TourFragmentPagerAdapter(this,getSupportFragmentManager());

        //sets the adapter on the viewpager
        viewPager.setAdapter(mAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
