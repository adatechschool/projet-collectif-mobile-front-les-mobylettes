package com.example.lesmobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class SpotList extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);

        List<String> spotNames = new ArrayList<>();

        for (SpotData.Spot spot : SpotData.SPOTS) {
            spotNames.add(spot.name);
        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            SpotData.Spot selectedSpot = SpotData.SPOTS.get(position);

            Intent intent = new Intent(SpotList.this, Spot.class);

            intent.putExtra("spot_name", selectedSpot.name);
            intent.putExtra("spot_description", selectedSpot.description);

            startActivity(intent);
        });
    }
}