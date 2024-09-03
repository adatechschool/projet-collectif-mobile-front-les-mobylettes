package com.example.lesmobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Spot extends AppCompatActivity {
    private TextView nameTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot); // Utilise spot.xml

        nameTextView = findViewById(R.id.spot_name);
        descriptionTextView = findViewById(R.id.spot_description);

        // Récupérer les données envoyées via l'intent
        Intent intent = getIntent();
        String spotName = intent.getStringExtra("spot_name");
        String spotDescription = intent.getStringExtra("spot_description");

        // Afficher les données
        nameTextView.setText(spotName);
        descriptionTextView.setText(spotDescription);
    }
}
