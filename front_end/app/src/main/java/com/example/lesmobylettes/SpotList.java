package com.example.lesmobylettes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpotList extends AppCompatActivity {

    private ListView listView;
    private List<SpotData.Record> spotList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);

        loadDataFromAssets();
    }

    private void loadDataFromAssets() {
        AssetManager assetManager = getAssets();
        try {
            InputStreamReader reader = new InputStreamReader(assetManager.open("Spot.json"));
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            bufferedReader.close();

            Gson gson = new Gson();
            String jsonResponse = jsonBuilder.toString();
            SpotData.Response spotResponse = gson.fromJson(jsonResponse, SpotData.Response.class);

            spotList = spotResponse.records;

            List<String> spotNames = new ArrayList<>();
            for (SpotData.Record record : spotList) {
                spotNames.add(record.fields.destination);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotNames);
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                SpotData.Record selectedSpot = spotList.get(position);

                Intent intent = new Intent(SpotList.this, Spot.class);

                intent.putExtra("destination", selectedSpot.fields.destination);
                intent.putExtra("surfBreak", selectedSpot.fields.surfBreak.get(0));
                intent.putExtra("address", selectedSpot.fields.address);
                intent.putExtra("difficultyLevel", selectedSpot.fields.difficultyLevel);
                intent.putExtra("peakSurfSeasonBegins", selectedSpot.fields.peakSurfSeasonBegins);
                intent.putExtra("peakSurfSeasonEnds", selectedSpot.fields.peakSurfSeasonEnds);
                if (selectedSpot.fields.photos != null && !selectedSpot.fields.photos.isEmpty()) {
                    intent.putExtra("photoUrl", selectedSpot.fields.photos.get(0).url);
                }

                startActivity(intent);
            });
        } catch (Exception e) {
            Toast.makeText(this, "Erreur de chargement des données", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
