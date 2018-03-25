package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.tourguideapp.R.layout.tour_item_list;


public class TravelToolsFragment extends Fragment {

    public TravelToolsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(tour_item_list, container, false);

        ArrayList<TourItem> travel_tools =  new ArrayList<TourItem>();


        travel_tools.add(new TourItem(R.string.transport,R.drawable.transporting));
        travel_tools.add(new TourItem(R.string.weather,R.drawable.weather));
        travel_tools.add(new TourItem(R.string.currency,R.drawable.euros));




        ItemAdapter adapter = new ItemAdapter(getActivity(),travel_tools);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
