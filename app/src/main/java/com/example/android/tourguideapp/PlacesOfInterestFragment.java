package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PlacesOfInterestFragment extends Fragment {

    public PlacesOfInterestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        //create and fill araylist
        ArrayList<TourItem> poi = new ArrayList<TourItem>();
        poi.add(new TourItem(R.string.restaurants, R.drawable.restaurants));
        poi.add(new TourItem(R.string.night, R.drawable.nightlife));
        poi.add(new TourItem(R.string.museums, R.drawable.museums));

        //create and set up adapetr
        ItemAdapter adapter = new ItemAdapter(getActivity(), poi);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //set listener
        setOnItemClickListener(listView,poi);

        return rootView;

    }


    private void setOnItemClickListener(ListView list, final ArrayList<TourItem> tourItems) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourItem currentItem = tourItems.get(position);

                //open next activity and store the name of category to be displayed
                Intent poiIntent = new Intent(getContext(), ExplicitInformationActivity.class);
                poiIntent.putExtra(Integer.toString(R.string.description),currentItem.getDescription());
                startActivity(poiIntent);
            }
        });
    }
}
