package com.example.banqueproject.dto;

import java.time.LocalDate;

public class CommandeDetailDto {

    // Commande info
    private int numCommande;
    private LocalDate dateCommande;

    // User info
    private int idClient;
    private String clientName;
    private String clientEmail;
    private String clientCity;
    private String clientTel;

    // Article info
    private String reference;      // designation in DB
    private String title;
    private String author;
    private double prix;

    // Ligne commande info
    private int qteCde;
    private double total;          // prix * qteCde

    public CommandeDetailDto(int numCommande, LocalDate dateCommande,
                             int idClient, String clientName, String clientEmail,
                             String clientCity, String clientTel,
                             String reference, String title, String author,
                             double prix, int qteCde) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.idClient = idClient;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientCity = clientCity;
        this.clientTel = clientTel;
        this.reference = reference;
        this.title = title;
        this.author = author;
        this.prix = prix;
        this.qteCde = qteCde;
        this.total = prix * qteCde;
    }

    public int getNumCommande() { return numCommande; }
    public LocalDate getDateCommande() { return dateCommande; }
    public int getIdClient() { return idClient; }
    public String getClientName() { return clientName; }
    public String getClientEmail() { return clientEmail; }
    public String getClientCity() { return clientCity; }
    public String getClientTel() { return clientTel; }
    public String getReference() { return reference; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrix() { return prix; }
    public int getQteCde() { return qteCde; }
    public double getTotal() { return total; }
}