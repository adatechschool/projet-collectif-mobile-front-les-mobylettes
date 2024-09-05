package com.example.lesmobylettes;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/*import com.example.lesmobylettes.R;*/
import java.util.List;



public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final List<SpotList> SpotList;// List to hold parsed surf records

    public MapsActivity(List<com.example.lesmobylettes.SpotList> spotList) {
        SpotList = spotList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        // TODO: Populate surfRecords by parsing JSON data
        // Example: SpotList = getSurfRecordsFromJson();

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        if (SpotList != null) {
            for (SpotList record : SpotList) {
                LatLng location = getLatLngFromGeocode(record.getGeocode());
                if (location != null) {
                    googleMap.addMarker(new MarkerOptions().position(location).title(record.getDestination()));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));  // Adjust zoom level as needed
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
        } else if (geocode.contains("Super bank")) {
            return new LatLng(-28.164968, 153.540920); // Example coordinates for Superbank, Gold Coast
        }
        return null; // or return a default location
    }
}




