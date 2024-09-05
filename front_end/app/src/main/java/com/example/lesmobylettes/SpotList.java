package com.example.lesmobylettes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SpotList extends AppCompatActivity {

    private ListView listView;
    private List<SpotData.Spot> spotList = new ArrayList<>();

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
            Type listType = new TypeToken<SpotData.Response>() {}.getType();
            SpotData.Response spotResponse = gson.fromJson(jsonResponse, listType);

            spotList = spotResponse.records;

            List<String> spotNames = new ArrayList<>();
            for (SpotData.Spot spot : spotList) {
                spotNames.add(spot.surfBreak); // Use surfBreak for the name
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotNames);
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                SpotData.Spot selectedSpot = spotList.get(position);

                Intent intent = new Intent(SpotList.this, Spot.class); // Correct activity class name

                intent.putExtra("surf_break", selectedSpot.surfBreak);
                intent.putExtra("photos", selectedSpot.photos);
                intent.putExtra("address", selectedSpot.address);

                startActivity(intent);
            });
        } catch (Exception e) {
            Toast.makeText(this, "Erreur de chargement des données", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
