package com.example.gestionmagasin;

import java.util.Vector;
import java.util.Iterator;
public class Caddie {
    int prix;
    String nomProduit = "peche";
    String code="jj";
    boolean commandeFaite = false ;
    Vector<Element> commande;
    public void EnregistreCommande() {
        commande = new Vector<Element>();
    }
    public void EffaceCommande() {
        commande.clear();
    }
    public String getCode () {
        return code;
    }
    public String getNomProduit () {
        return nomProduit;
    }
    public int getPrix () {
        return prix;
    }
        public void commander () {
            commande.add (new Element(nomProduit, code, prix));
            commandeFaite = false;
        }
        public Iterator iterator () {
            return commande.iterator();
        }
        public boolean getCommandeFaite () {
            return commandeFaite;
        }
        public void setNomProduit (String val) {
            nomProduit = val;
            commandeFaite = true;
        }
        public void setCode (String val) {
            code = val;
            commandeFaite = true;
        }
        public void setPrix (int val) {
            prix = val;
            commandeFaite = true;
        }

    }
