package com.example.lesmobylettes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class Spot extends AppCompatActivity {

    private TextView spotName;
    private TextView spotDescription;
    private ImageView spotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot); // Ensure this layout file exists

        spotName = findViewById(R.id.spot_name);
        spotDescription = findViewById(R.id.spot_description);
        spotImage = findViewById(R.id.spot_image); // Ensure this ImageView exists in the layout

        Intent intent = getIntent();
        String surfBreak = intent.getStringExtra("surf_break");
        String photos = intent.getStringExtra("photos");
        String address = intent.getStringExtra("address");

        spotName.setText(surfBreak);
        spotDescription.setText(address);

        if (photos != null && !photos.isEmpty()) {
            Glide.with(this).load(photos).into(spotImage); // Use Glide or Picasso for image loading
        }
    }
}
