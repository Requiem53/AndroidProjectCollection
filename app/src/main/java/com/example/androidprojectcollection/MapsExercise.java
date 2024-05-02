package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class MapsExercise extends AppCompatActivity {

    ScrollView locationContainer;

    ImageButton location1;
    ImageButton location2;
    ImageButton location3;
    ImageButton location4;
    ImageButton location5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        locationContainer = findViewById(R.id.location_container);

        location1 = findViewById(R.id.locationPin1);
        location2 = findViewById(R.id.locationPin2);
        location3 = findViewById(R.id.locationPin3);
        location4 = findViewById(R.id.locationPin4);
        location5 = findViewById(R.id.locationPin5);

        location1.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.332545, 123.750881"));
            locationContainer.setBackgroundResource(R.drawable.place1bg);
            startActivity(intent1);
        });

        location2.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.08168356655645, 138.85506385933817"));
            locationContainer.setBackgroundResource(R.drawable.place2bg);
            startActivity(intent1);
        });

        location3.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:52.079311927433245, 4.304873953904129"));
            locationContainer.setBackgroundResource(R.drawable.place3bg);
            startActivity(intent1);
        });

        location4.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.891086, 12.492450"));
            locationContainer.setBackgroundResource(R.drawable.place4bg);
            startActivity(intent1);
        });

        location5.setOnClickListener(view -> {
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.69424511548379, 13.893115943490999"));
            locationContainer.setBackgroundResource(R.drawable.place5bg);
            startActivity(intent1);
        });
    }

}