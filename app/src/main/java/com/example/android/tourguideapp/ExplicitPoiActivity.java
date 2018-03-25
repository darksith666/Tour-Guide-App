package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ExplicitPoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_poi);

        //TODO intent not working
        Intent mIntent = getIntent();
        String descreption = mIntent.getStringExtra("description");


        if(descreption.equals(R.string.restaurants)){
            Toast.makeText(ExplicitPoiActivity.this,"I didit",Toast.LENGTH_LONG).show();
        }
    }
}
