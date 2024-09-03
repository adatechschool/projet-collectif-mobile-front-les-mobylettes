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

        // Créer une liste de noms de plages à partir de SpotData.SPOTS
        List<String> spotNames = new ArrayList<>();
        for (SpotData.Spot spot : SpotData.SPOTS) {
            spotNames.add(spot.nom);
        }

        // Utiliser la liste de noms pour l'ArrayAdapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotNames);
        listView.setAdapter(arrayAdapter);

        // Ajouter un listener pour gérer les clics sur les éléments de la liste
        listView.setOnItemClickListener((parent, view, position, id) -> {
            SpotData.Spot selectedSpot = SpotData.SPOTS.get(position);

            // Lancer Spot.java et passer les détails du spot
            Intent intent = new Intent(SpotList.this, Spot.class);
            intent.putExtra("spot_name", selectedSpot.nom);
            intent.putExtra("spot_description", selectedSpot.description);
            startActivity(intent);
        });
    }
}
