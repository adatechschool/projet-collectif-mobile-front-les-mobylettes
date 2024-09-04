package com.example.lesmobylettes;

// Importation des classes nécessaires pour le bon fonctionnement de l'activité.
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

// Déclaration de la classe SpotList qui hérite de AppCompatActivity,
// une classe de base pour les activités qui utilisent les fonctionnalités de la bibliothèque AppCompat.
public class SpotList extends AppCompatActivity {

    // Déclaration des variables de la classe.
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    // Méthode appelée lorsque l'activité est créée. C'est ici que vous définissez la mise en page de l'activité
    // et initialisez les composants.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Spécifie la mise en page XML à utiliser pour cette activité.
        setContentView(R.layout.spot_list);

        // Initialisation de la ListView en la liant à l'élément d'interface utilisateur défini dans le fichier XML.
        listView = findViewById(R.id.list_view_id);

        // Création d'une liste vide pour stocker les noms des spots (plages) à partir des données disponibles.
        List<String> spotNames = new ArrayList<>();

        // Boucle à travers les données des spots pour extraire les noms et les ajouter à la liste spotNames.
        for (SpotData.Spot spot : SpotData.SPOTS) {
            spotNames.add(spot.nom);
        }

        // Création d'un ArrayAdapter pour convertir la liste de noms de spots en éléments de la ListView.
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotNames);

        // Associe l'adaptateur à la ListView pour afficher les noms des spots.
        listView.setAdapter(arrayAdapter);

        // Ajoute un listener pour écouter les clics sur les éléments de la liste.
        listView.setOnItemClickListener((parent, view, position, id) -> {

            // Récupère le spot sélectionné à la position cliquée.
            SpotData.Spot selectedSpot = SpotData.SPOTS.get(position);

            // Crée une nouvelle intention pour lancer l'activité Spot (qui affichera les détails du spot).
            Intent intent = new Intent(SpotList.this, Spot.class);

            // Ajoute les détails du spot sélectionné (nom et description) comme extras à l'intention.
            intent.putExtra("spot_name", selectedSpot.nom);
            intent.putExtra("spot_description", selectedSpot.description);

            // Démarre l'activité Spot avec l'intention créée, ce qui ouvre une nouvelle page affichant les détails du spot sélectionné.
            startActivity(intent);
        });
    }
}

