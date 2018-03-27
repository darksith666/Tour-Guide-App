package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class PlacesOfInterestFragment extends Fragment {

    public PlacesOfInterestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        final ArrayList<TourItem> poi = new ArrayList<TourItem>();

        poi.add(new TourItem(R.string.restaurants, R.drawable.restaurants));
        poi.add(new TourItem(R.string.night, R.drawable.nightlife));
        poi.add(new TourItem(R.string.museums, R.drawable.museums));


        ItemAdapter adapter = new ItemAdapter(getActivity(), poi);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(mMessageClickedHandler);


//       //not working right now does not show anything
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View v, int position,
//                                    long arg3) {
//                //TourItem value = (TourItem) adapter.getItemAtPosition(position);
//                Toast.makeText(getContext(),"mphkame",Toast.LENGTH_LONG).show();
//            }
//        });

        return rootView;

    }


    //error without importing class
    //it show nothing when I select an item
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id)
        {

            Toast.makeText(getContext(),"You've got an event",Toast.LENGTH_SHORT).show();
        }
    };


    //TODO make this listener work
    private void setOnItemClickListener(ListView list, final ArrayList<TourItem> tourItems) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourItem currentItem = tourItems.get(position);


                //open next activity and store the name of category to be displayed
                Intent poiIntent = new Intent(getContext(), ExplicitPoiActivity.class);
                poiIntent.putExtra("description",currentItem.getDescription());

                Toast.makeText(getContext(),"poi poi",Toast.LENGTH_LONG).show();

                startActivity(poiIntent);
            }
        });
    }
}
