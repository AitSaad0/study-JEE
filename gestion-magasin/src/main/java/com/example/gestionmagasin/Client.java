package com.example.gestionmagasin;
public class Client {
    private String nom;
    private String password;

    public Client() {};
    public Client(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String mp) {
        return password.equals(mp);
    }
}