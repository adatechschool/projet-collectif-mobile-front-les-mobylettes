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
        setContentView(R.layout.spot);

        // Initialise les TextViews en les recherchant dans le layout
        nameTextView = findViewById(R.id.spot_name);
        descriptionTextView = findViewById(R.id.spot_description);

        // Récupère les données envoyées à cette activité via l'intent
        Intent intent = getIntent();
        String spotName = intent.getStringExtra("spot_name");
        String spotDescription = intent.getStringExtra("spot_description");

        // Affiche les données récupérées dans les TextViews
        nameTextView.setText(spotName);
        descriptionTextView.setText(spotDescription);
    }
}
