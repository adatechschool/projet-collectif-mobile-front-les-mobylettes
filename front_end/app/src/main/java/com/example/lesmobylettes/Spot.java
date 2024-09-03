package com.example.lesmobylettes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SpotList extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);

        listView = findViewById(R.id.list_view_id);
        listView.setAdapter(new SpotAdapter());
    }

    private class SpotAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return SpotData.SPOTS.size();
        }

        @Override
        public Object getItem(int position) {
            return SpotData.SPOTS.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(SpotList.this).inflate(R.layout.spot, parent, false);
            }

            TextView nameTextView = convertView.findViewById(R.id.spot_name);
            TextView descriptionTextView = convertView.findViewById(R.id.spot_description);

            SpotData.Spot spot = SpotData.SPOTS.get(position);
            nameTextView.setText(spot.nom);
            descriptionTextView.setText(spot.description);

            return convertView;
        }
    }
}