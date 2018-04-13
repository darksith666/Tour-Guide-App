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

import static com.example.android.tourguideapp.R.layout.tour_item_list;


public class TravelToolsFragment extends Fragment {

    public TravelToolsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(tour_item_list, container, false);

        //create an arraylist of travel tools
        ArrayList<TourItem> travel_tools =  new ArrayList<TourItem>();
        travel_tools.add(new TourItem(R.string.transport,R.drawable.transporting));
        travel_tools.add(new TourItem(R.string.weather,R.drawable.weather));
        travel_tools.add(new TourItem(R.string.currency,R.drawable.euros));

        //set up the custom adapter
        ItemAdapter adapter = new ItemAdapter(getActivity(),travel_tools);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //sets the listener waiting for clicks
        setOnItemClickListener(listView,travel_tools);

        return rootView;
    }

    //here is the implementation of the listener in which we open an activity to handle the clicks
    //and provide the right website
    private void setOnItemClickListener(ListView list, final ArrayList<TourItem> tourItems) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourItem currentItem = tourItems.get(position);


                //open next activity and store the name of category to be displayed
                Intent travelToolsIntent = new Intent(getContext(), ExplicitInformationActivity.class);
                travelToolsIntent.putExtra(Integer.toString(R.string.description),currentItem.getDescription());

                startActivity(travelToolsIntent);
            }
        });
    }
}
