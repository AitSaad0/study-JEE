package com.example.gestionmagasin;

import java.io.IOException;
public class Stock {
    public static String [] [] leStock = {
            {"Disque CD - Patrick Bruel", "15", "897TR566"},
            {"Disque CD - Los Mayas", "19", "78UUNYT67"},
            {"Disque CD - Dick Anglas", "25", "87YHG564"},
            {"Disque CD - Frederic Angonas", "35", "98HUYU56"}
    };

    public static String[] rechercheParNom(String nomProduit) {
        boolean trouve = false;
        for (int i = 0; i < leStock.length; i++) {
            if (leStock[i][0].equalsIgnoreCase(nomProduit)) {
                return leStock[i];
            }
        }
        return null;
    }

    public static String[] rechercheParCode(String code) {
        boolean trouve = false;
        for (int i = 0; i < leStock.length; i++) {
            if (leStock[i][2].equalsIgnoreCase(code)) {
                return leStock[i];
            }
        }
            return null;
        }
}
