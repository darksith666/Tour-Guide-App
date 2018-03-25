package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        ArrayList<TourItem> sights =  new ArrayList<TourItem>();

        sights.add(new TourItem(R.string.parthenon,R.drawable.parthenon_1,true));
        sights.add(new TourItem(R.string.agora,R.drawable.agora,true));
        sights.add(new TourItem(R.string.anafiotika,R.drawable.anaf,true));




        ItemAdapter adapter = new ItemAdapter(getActivity(),sights);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(getActivity(), "hey", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        return rootView;
    }

}
