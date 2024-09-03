package com.example.lesmobylettes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class SpotList extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);

        // ici on utlise la liste définie dans SpotData
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpotData.SPOTS);
        listView.setAdapter(arrayAdapter);
    }
}
