package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ExplicitPoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_poi);


        Intent mIntent = getIntent();
        int description = mIntent.getIntExtra("d",0);



        switch (description) {

            case R.string.restaurants: goToUrl("https://www.tripadvisor.com.gr/Restaurants-g29209-Athens_Georgia.html");
                break;
            case R.string.night: goToUrl("https://www.tripadvisor.com.gr/Attractions-g189400-Activities-c20-t99-Athens_Attica.html");
                break;
            case R.string.museums: goToUrl("https://www.tripadvisor.com.gr/Attractions-g189400-Activities-c49-Athens_Attica.html");
                break;
            case R.string.transport: goToUrl("https://www.google.com/maps/d/viewer?oe=UTF8&msa=0&ie=UTF8&mid=17m9z8jkpWii4C7QEDy2ubXZ4yuY&ll=37.97830399999999%2C23.715363000000025&z=17");
                break;
            case R.string.currency: goToUrl("https://www.x-rates.com/calculator/?from=EUR&to=USD&amount=1");
                break;
            case R.string.weather: goToUrl("http://www.meteo.gr/cf-En.cfm?city_id=12");
                break;
            case R.string.parthenon: goToUrl("http://www.visitgreece.gr/en/culture/monuments/parthenon");
                break;
            case R.string.anafiotika: goToUrl("https://europeupclose.com/article/anafiotika-the-hidden-village-under-the-acropolis/");
                break;
            case R.string.agora: goToUrl("https://www.tripadvisor.com.gr/Attraction_Review-g189400-d242841-Reviews-Roman_Agora-Athens_Attica.html");
                break;

        }
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
