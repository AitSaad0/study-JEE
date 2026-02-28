package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.CommandesDaoImpl;
import com.example.banqueproject.dao.inte.CommandesDao;
import com.example.banqueproject.dto.CommandeDetailDto;
import com.example.banqueproject.entity.Commandes;
import com.example.banqueproject.entity.LignesCommande;
import com.example.banqueproject.service.CommandesService;

import java.util.List;
import java.util.NoSuchElementException;

public class CommandesServiceImpl implements CommandesService {

    private final CommandesDao commandesDao = new CommandesDaoImpl();

    @Override
    public List<CommandeDetailDto> getCommandeDetails(int idClient) {
        return commandesDao.findDetailByIdClient(idClient); // empty list is fine, no exception needed
    }

    @Override
    public List<Commandes> getCommandesByIdClient(int idClient) {
        List<Commandes> commandes = commandesDao.findByIdClient(idClient);
        if (commandes.isEmpty()) {
            throw new NoSuchElementException("No commandes found for client: " + idClient);
        }
        return commandes;
    }

    @Override
    public List<LignesCommande> getLignesByNumCommande(int numCommande) {
        List<LignesCommande> lignes = commandesDao.findByNumCommande(numCommande);
        if (lignes.isEmpty()) {
            throw new NoSuchElementException("No lignes found for commande: " + numCommande);
        }
        return lignes;
    }

    @Override
    public List<LignesCommande> getLignesByCodeArticle(int codeArticle) {
        List<LignesCommande> lignes = commandesDao.findByCodeArticle(codeArticle);
        if (lignes.isEmpty()) {
            throw new NoSuchElementException("No lignes found for article: " + codeArticle);
        }
        return lignes;
    }

    @Override
    public boolean passCommande(int idClient, int codeArticle, int qteCde) {
        if (qteCde <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        return commandesDao.addCommandeWithLigne(idClient, codeArticle, qteCde);
    }
}