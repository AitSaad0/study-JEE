package com.example.banqueproject.service;

import com.example.banqueproject.dto.CommandeDetailDto;
import com.example.banqueproject.entity.Commandes;
import com.example.banqueproject.entity.LignesCommande;

import java.util.List;

public interface CommandesService {
    List<Commandes> getCommandesByIdClient(int idClient);
    List<LignesCommande> getLignesByNumCommande(int numCommande);
    List<LignesCommande> getLignesByCodeArticle(int codeArticle);
    boolean passCommande(int idClient, int codeArticle, int qteCde);
    List<CommandeDetailDto> getCommandeDetails(int idClient);
}