package com.example.banqueproject.dto;

public class ArticlesDto {

    private int codeArticle;
    private String designation;
    private double prix;
    private Integer stock;
    private Integer categorie;
    private String photo;
    private String titre;
    private String auteur;

    public ArticlesDto() {}

    public ArticlesDto(int codeArticle, String designation, double prix, Integer stock, Integer categorie, String photo, String titre, String auteur) {
        this.codeArticle = codeArticle;
        this.designation = designation;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.photo = photo;
        this.titre = titre;
        this.auteur = auteur;
    }

    // Constructor sans ID (pour insert)
    public ArticlesDto(String designation, double prix, Integer stock, Integer categorie, String photo, String titre, String auteur) {
        this.designation = designation;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.photo = photo;
        this.titre = titre;
        this.auteur = auteur;
    }

    // Getters & Setters
    public int getCodeArticle() { return codeArticle; }
    public void setCodeArticle(int codeArticle) { this.codeArticle = codeArticle; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getCategorie() { return categorie; }
    public void setCategorie(Integer categorie) { this.categorie = categorie; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
}
