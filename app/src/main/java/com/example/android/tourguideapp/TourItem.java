package com.example.android.tourguideapp;

/**
 * Created by giorgosnty on 21/3/2018.
 */

public class TourItem {

    private int description;
    private int imgResource;
    private boolean isSights = false;


    public TourItem(int description, int imgResource) {
        this.description = description;
        this.imgResource = imgResource;

    }

    public TourItem(int description, int imgResource, boolean isSights) {
        this.description = description;
        this.imgResource = imgResource;
        this.isSights = isSights;

    }

    //gets image resource of the object
    public int getImgResource() {
        return imgResource;
    }

    //gets description of object
    public int getDescription() {
        return description;
    }

    //returns if the Fragment is about sights
    public boolean isSights() {
        return isSights;
    }


}
