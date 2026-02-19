package com.example.gestionmagasin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Utilisateurs {
    private Map<String, Client> clients = new HashMap<>();

    public void ajouterClient(Client c) {
        clients.put(c.getNom(), c);
    }

    public boolean clientExiste(String nom) {
        return clients.containsKey(nom);
    }

    public boolean authentifier(String nom, String mp) {
        Client c = clients.get(nom);
        if (c == null) return false;
        return c.checkPassword(mp);
    }
}