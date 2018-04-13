package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by giorgosnty on 21/3/2018.
 */

public class ItemAdapter extends ArrayAdapter<TourItem> {


    public ItemAdapter(Activity context, ArrayList<TourItem> tourItems) {
        super(context,0,tourItems);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        }

        final TourItem currentItem = getItem(position);

        //it fills the image with the current imageresource
        ImageView currentImg = (ImageView) listItemView.findViewById(R.id.imgView);
        currentImg.setImageResource(currentItem.getImgResource());

        //here it checks if the current item is a sight because then we want a different TextView
        if(currentItem.isSights()) {
            //it gets the right textview and sets it to the current TourItem object
            TextView currentDescription = (TextView) listItemView.findViewById(R.id.descr);
            currentDescription.setText(currentItem.getDescription());
        }else{
            TextView currentDescription = (TextView) listItemView.findViewById(R.id.descr_2);
            currentDescription.setText(currentItem.getDescription());
            }

        return listItemView;
    }



}
