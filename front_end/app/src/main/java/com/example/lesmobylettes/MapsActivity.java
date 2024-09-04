package com.example.lesmobylettes;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    private List<SurfRecord> surfRecords; // List to hold parsed surf records

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // TODO: Populate surfRecords by parsing JSON data
        // Example: surfRecords = getSurfRecordsFromJson();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        if (surfRecords != null) {
            for (SurfRecord record : surfRecords) {
                LatLng location = getLatLngFromGeocode(record.getGeocode());
                if (location != null) {
                    myMap.addMarker(new MarkerOptions().position(location).title(record.getDestination()));
                    myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));  // Adjust zoom level as needed
                }
            }
        }
    }

    private LatLng getLatLngFromGeocode(String geocode) {
        // Dummy implementation:
        if (geocode.contains("Skeleton Bay")) {
            return new LatLng(-25.9144919, 14.906859); // Example coordinates for Skeleton Bay
        } else if (geocode.contains("Pipeline")) {
            return new LatLng(21.664968, -158.050920); // Example coordinates for Pipeline, Hawaii
        } else if (geocode.contains("Superbank")) {
            return new LatLng(-28.164968, 153.540920); // Example coordinates for Superbank, Gold Coast
        }
        return null; // or return a default location
    }
}

