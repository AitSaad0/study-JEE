package com.example.banqueproject.entity;

public class Clients {

    private int id;
    private String email;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String tel;
    private String mdp;

    public Clients(String email, String nom, String adresse, String codePostal, String ville, String tel, String mdp){
        this.email = email;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.mdp = mdp;
    }
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal){
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMdp(){
        return this.mdp;
    }

    public void setMdp(String mdp){
        this.mdp = mdp;
    }
}
