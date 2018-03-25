package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by giorgosnty on 20/3/2018.
 */

public class TourFragmentPagerAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public TourFragmentPagerAdapter(Context context ,FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new SightsFragment();
        }else if(position==1){
            return new PlacesOfInterestFragment();
        }else{
            return new TravelToolsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_sights);
        } else if (position == 1) {
            return mContext.getString(R.string.category_poi);
        } else {
            return mContext.getString(R.string.category_travel_tools);
        }
    }
}
