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
 * Created by giorgosnty on 12/4/2018.
 */

public class ShoppingFragment extends Fragment {

    public ShoppingFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_item_list, container, false);

        //create and fill araylist
        ArrayList<TourItem> shopping = new ArrayList<TourItem>();
        shopping.add(new TourItem(R.string.mall, R.drawable.the_mall));
        shopping.add(new TourItem(R.string.ermou, R.drawable.ermou));
        shopping.add(new TourItem(R.string.golden_hall, R.drawable.golden_hall));

        //create and set up adapetr
        ItemAdapter adapter = new ItemAdapter(getActivity(), shopping);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //set listener
        setOnItemClickListener(listView,shopping);


        return rootView;

    }


    private void setOnItemClickListener(ListView list, final ArrayList<TourItem> tourItems) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TourItem currentItem = tourItems.get(position);
                //open next activity and store the name of category to be displayed
                Intent shoppingFragmentIntent = new Intent(getContext(), ExplicitInformationActivity.class);
                shoppingFragmentIntent.putExtra(Integer.toString(R.string.description),currentItem.getDescription());
                startActivity(shoppingFragmentIntent);
            }
        });
    }
}
