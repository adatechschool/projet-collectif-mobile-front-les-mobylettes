package com.example.lesmobylettes;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SpotData {
    public static class Record {
        public String id;
        public Fields fields;
        public String createdTime;
    }

    public static class Fields {
        @SerializedName("Surf Break")
        public List<String> surfBreak;

        @SerializedName("Difficulty Level")
        public int difficultyLevel;

        @SerializedName("Destination")
        public String destination;

        @SerializedName("Geocode")
        public String geocode;

        @SerializedName("Influencers")
        public List<String> influencers;

        @SerializedName("Magic Seaweed Link")
        public String magicSeaweedLink;

        @SerializedName("Photos")
        public List<Photo> photos;

        @SerializedName("Peak Surf Season Begins")
        public String peakSurfSeasonBegins;

        @SerializedName("Destination State/Country")
        public String destinationStateCountry;

        @SerializedName("Peak Surf Season Ends")
        public String peakSurfSeasonEnds;

        @SerializedName("Address")
        public String address;
    }

    public static class Photo {
        public String id;
        public String url;
        public String filename;
        public int size;
        public String type;
        public Thumbnails thumbnails;
    }

    public static class Thumbnails {
        public ThumbnailInfo small;
        public ThumbnailInfo large;
        public ThumbnailInfo full;
    }

    public static class ThumbnailInfo {
        public String url;
        public int width;
        public int height;
    }

    public static class Response {
        public List<Record> records;
        public String offset;
    }
}
