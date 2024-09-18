package com.example.les_mobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class SpotList extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private List<SpotData.Record> spotList = new ArrayList<>();  // Ajout de cette liste pour garder les données

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listView.setAdapter(arrayAdapter);

        loadSpotsFromApi();

        // Ajout du Listener pour détecter les clics sur les éléments de la liste
        listView.setOnItemClickListener((parent, view, position, id) -> {
            SpotData.Record selectedRecord = spotList.get(position); // Récupérer l'élément sélectionné

            // Intent pour démarrer l'activité Spot et passer les données du spot sélectionné
            Intent intent = new Intent(SpotList.this, Spot.class);
            intent.putExtra("destination", selectedRecord.destination);
            intent.putExtra("surfBreak", selectedRecord.surfBreak);
            intent.putExtra("address", selectedRecord.address);
            intent.putExtra("difficultyLevel", selectedRecord.difficultyLevel);
            intent.putExtra("peakSeasonBegins", selectedRecord.peakSurfSeasonBegins);
            intent.putExtra("peakSeasonEnds", selectedRecord.peakSurfSeasonEnds);
            intent.putExtra("photoUrl", selectedRecord.photoUrl);

            startActivity(intent);  // Démarrer l'activité Spot
        });
    }

    private void loadSpotsFromApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")  // URL de l'API locale
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SpotData.Record>> call = apiService.getSpots();

        call.enqueue(new Callback<List<SpotData.Record>>() {
            @Override
            public void onResponse(Call<List<SpotData.Record>> call, Response<List<SpotData.Record>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    spotList = response.body();  // Stocker les données récupérées dans spotList
                    List<String> spotNames = new ArrayList<>();

                    // Ajouter chaque nom de spot dans la liste
                    for (SpotData.Record record : spotList) {
                        spotNames.add(record.surfBreak);  // Afficher le nom du surf break dans la liste
                    }

                    // Mettre à jour la ListView avec les noms des spots
                    arrayAdapter.clear();
                    arrayAdapter.addAll(spotNames);
                } else {
                    Toast.makeText(SpotList.this, "Erreur lors de la réponse de l'API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SpotData.Record>> call, Throwable t) {
                Toast.makeText(SpotList.this, "Échec de la connexion à l'API", Toast.LENGTH_SHORT).show();
                Log.e("SpotList", "Échec de la connexion à l'API", t);
            }
        });
    }
}
