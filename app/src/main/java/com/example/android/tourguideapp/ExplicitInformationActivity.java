package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ExplicitInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_poi);


        //we get the Intent coming from the click of an item in our app and store the description
        Intent mIntent = getIntent();
        int description = mIntent.getIntExtra(Integer.toString(R.string.description),0);


        //here depending on the button we handle the applicable link
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
            case R.string.ermou: goToUrl("https://www.athensguide.com/ermou/index.htm");
                break;
            case R.string.mall: goToUrl("https://themallathens.gr/gre/");
                break;
            case R.string.golden_hall: goToUrl("https://goldenhall.gr/gr/");
                break;
            default: goToUrl("https://www.dafont.com/good-day.font");

        }
        //this line is to avoid a return to an empty activity
        finish();

    }

    //this function starts an Intent to visit a url
    private void goToUrl (String url) {
        Uri myUrl = Uri.parse(url);
        Intent openBrowser = new Intent(Intent.ACTION_VIEW, myUrl);
        startActivity(openBrowser);

    }
}
