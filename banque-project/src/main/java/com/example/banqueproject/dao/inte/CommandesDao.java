package com.example.banqueproject.dao.inte;

import com.example.banqueproject.dto.CommandeDetailDto;
import com.example.banqueproject.entity.Commandes;
import com.example.banqueproject.entity.LignesCommande;

import java.util.List;

public interface CommandesDao {
    public List<CommandeDetailDto> findDetailByIdClient(int idClient) ;
    List<Commandes> findByIdClient(int idClient);
    List<LignesCommande> findByNumCommande(int numCommande);
    List<LignesCommande> findByCodeArticle(int codeArticle);
    public boolean addCommandeWithLigne(int idClient, int codeArticle, int qteCde);
        }