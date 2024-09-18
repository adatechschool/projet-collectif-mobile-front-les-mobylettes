package com.example.les_mobylettes;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SpotData {

    public static class Record {
        public String id;
        public String surfBreak;
        public int difficultyLevel;
        public String destination;
        public String geocode;
        public String peakSurfSeasonBegins;
        public String destinationStateCountry;
        public String address;
        public String peakSurfSeasonEnds;
        public String photoUrl;
    }

    public static class Fields {
        @SerializedName("Surf Break")
        public String surfBreak;

        @SerializedName("Difficulty Level")
        public int difficultyLevel;

        @SerializedName("Destination")
        public String destination;

        @SerializedName("Geocode")
        public String geocode;

        @SerializedName("Peak Surf Season Begins")
        public String peakSurfSeasonBegins;

        @SerializedName("Peak Surf Season Ends")
        public String peakSurfSeasonEnds;

        @SerializedName("Destination State/Country")
        public String destinationStateCountry;

        @SerializedName("Address")
        public String address;

        @SerializedName("Photo URL")
        public String photoUrl;
    }

    public static class Response {
        public List<Record> records;
        public String offset;
    }
}
