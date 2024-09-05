package com.example.lesmobylettes;

import java.util.List;

public class SpotData {
    public static class Spot {
        public String surfBreak;
        public String photos;
        public String address;

        public Spot(String surfBreak, String photos, String address) {
            this.surfBreak = surfBreak;
            this.photos = photos;
            this.address = address;
        }
    }

    public static class Response {
        public List<Spot> records;
    }
}
