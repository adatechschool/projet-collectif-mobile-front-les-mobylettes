package com.example.lesmobylettes;

import java.util.List;
import java.util.Arrays;

public class SpotData {
    public static class Spot {
        public String nom;
        public String description;

        public Spot(String nom, String description) {
            this.nom = nom;
            this.description = description;
        }
    }

    public static final List<Spot> SPOTS = Arrays.asList(
            new Spot("Plage 1", "Description de la plage 1"),
            new Spot("Plage 2", "Description de la plage 2"),
            new Spot("Plage 3", "Description de la plage 3"),
            new Spot("Plage 4", "Description de la plage 4"),
            new Spot("Plage 5", "Description de la plage 5"),
            new Spot("Plage 6", "Description de la plage 6")
    );
}
