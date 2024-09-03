package com.example.lesmobylettes;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;



public class SpotList extends AppCompatActivity {

    private ListView listView;
    private final String[] spots = new String[]{
            "Liste 1",
            "Liste 2",
            "Liste 3",
            "liste 4"
    };
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spots);
        listView.setAdapter(arrayAdapter);
    }
}
