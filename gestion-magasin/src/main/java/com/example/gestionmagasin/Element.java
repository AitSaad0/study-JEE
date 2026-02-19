package com.example.gestionmagasin;

public class Element {
    protected String nomProduit, code;
    protected int prix;
    public Element(String leProduit, String
            leCode, int lePrix) {
        nomProduit = leProduit;
        code = leCode;
        prix = lePrix;
    }
    public String toString() {
        return " produit : " +
                nomProduit + " code : " + code + " prix: " + prix ;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public String getCode() {
        return code;
    }
    public int getPrix() {
        return prix;
    }
    public void setNomProduit(String val) {
        nomProduit = val;
    }
    public void setCode(String val ) {
        code = val;
    }
    public void setPrix(int val ) {
        prix = val;
    }}
