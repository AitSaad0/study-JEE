package com.example.banqueproject.entity;

public class Articles {

    private int codeArticle;
    private String reference;
    private double prix;
    private Integer stock;
    private Integer categorie;
    private String photo;
    private String title;
    private String author;

    // ===== Constructors =====
    public Articles() {}

    public Articles(String reference, double prix, Integer stock, Integer categorie, String photo, String title, String author) {
        this.reference = reference;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.photo = photo;
        this.title = title;
        this.author = author;
    }

    // ===== Getters & Setters =====
    public int getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
