package com.rafal.gpstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowLocation;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.btnLocation);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gps = new GPSTracker(MainActivity.this);
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(getApplicationContext(), "Your Location is Lat: " + latitude
                            + ",Lng: " + longitude, Toast.LENGTH_SHORT).show();
                }else {
                    gps.showSettingsAlert();
                }
            }
        });
    }
}