package com.example.lesmobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class Spot extends AppCompatActivity {

    private TextView destinationText;
    private TextView surfBreakText;
    private TextView addressText;
    private TextView difficultyLevelText;
    private TextView peakSeasonText;
    private ImageView spotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot);

        destinationText = findViewById(R.id.destination_text);
        surfBreakText = findViewById(R.id.surf_break_text);
        addressText = findViewById(R.id.address_text);
        difficultyLevelText = findViewById(R.id.difficulty_level_text);
        peakSeasonText = findViewById(R.id.peak_season_text);
        spotImage = findViewById(R.id.spot_image);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destination");
        String surfBreak = intent.getStringExtra("surfBreak");
        String address = intent.getStringExtra("address");
        int difficultyLevel = intent.getIntExtra("difficultyLevel", 0);
        String peakSurfSeasonBegins = intent.getStringExtra("peakSurfSeasonBegins");
        String peakSurfSeasonEnds = intent.getStringExtra("peakSurfSeasonEnds");
        String photoUrl = intent.getStringExtra("photoUrl");

        destinationText.setText("Destination: " + destination);
        surfBreakText.setText("Surf Break: " + surfBreak);
        addressText.setText("Address: " + address);
        difficultyLevelText.setText("Difficulty Level: " + difficultyLevel);
        peakSeasonText.setText("Peak Season: " + peakSurfSeasonBegins + " to " + peakSurfSeasonEnds);

        if (photoUrl != null && !photoUrl.isEmpty()) {
            Glide.with(this).load(photoUrl).into(spotImage);
        }
    }
}