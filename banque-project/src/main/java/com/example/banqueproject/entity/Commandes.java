package com.example.banqueproject.entity;

import java.time.LocalDate;

public class Commandes {
    private int numCommande;
    private LocalDate dateCommande;
    private int idClient;


    public Commandes() {}

    public Commandes(int numCommande, LocalDate dateCommande, int idClient) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.idClient = idClient;
    }

    public int getNumCommande() { return numCommande; }
    public void setNumCommande(int numCommande) { this.numCommande = numCommande; }

    public LocalDate getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }

    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }
}
