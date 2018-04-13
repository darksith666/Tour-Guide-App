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

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        //create and initiate arraylist
        ArrayList<TourItem> sights =  new ArrayList<TourItem>();
        sights.add(new TourItem(R.string.parthenon,R.drawable.parthenon_1,true));
        sights.add(new TourItem(R.string.anafiotika,R.drawable.anaf,true));
        sights.add(new TourItem(R.string.agora,R.drawable.agora,true));

        //set up the adapter
        ItemAdapter adapter = new ItemAdapter(getActivity(),sights);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //set up the listener
        setOnItemClickListener(listView,sights);

        return rootView;
    }

    private void setOnItemClickListener(ListView list, final ArrayList<TourItem> tourItems) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourItem currentItem = tourItems.get(position);

                //open next activity and store the name of category to be displayed
                Intent sightsIntent = new Intent(getContext(), ExplicitInformationActivity.class);
                sightsIntent.putExtra(Integer.toString(R.string.description),currentItem.getDescription());
                startActivity(sightsIntent);
            }
        });
    }
}
