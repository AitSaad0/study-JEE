package com.example.banqueproject.dao.impl;


import com.example.banqueproject.dao.DBConnection;
import com.example.banqueproject.dao.inte.CommandesDao;
import com.example.banqueproject.dto.CommandeDetailDto;
import com.example.banqueproject.entity.Commandes;
import com.example.banqueproject.entity.LignesCommande;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommandesDaoImpl implements CommandesDao {

    private static final String FIND_BY_ID_CLIENT =
            "SELECT numCommande, dateCommande, idClient FROM commandes WHERE idClient = ?";


    private static final String FIND_BY_NUM_COMMANDE =
            "SELECT numCommande, codeArticle, qteCde FROM lignescommande WHERE numCommande = ?";

    private static final String FIND_BY_CODE_ARTICLE =
            "SELECT numCommande, codeArticle, qteCde FROM lignescommande WHERE codeArticle = ?";

    private static final String INSERT_COMMANDE =
            "INSERT INTO commandes (dateCommande, idClient) VALUES (?, ?)";

    private static final String INSERT_LIGNE_COMMANDE =
            "INSERT INTO lignescommande (numCommande, codeArticle, qteCde) VALUES (?, ?, ?)";


    private static final String FIND_DETAIL_BY_ID_CLIENT =
            "SELECT c.numCommande, c.dateCommande, " +
                    "       u.id AS idClient, u.name, u.email, u.city, u.tel, " +
                    "       a.designation AS reference, a.title, a.author, a.prix, " +
                    "       lc.qteCde " +
                    "FROM commandes c " +
                    "JOIN lignescommande lc ON c.numCommande = lc.numCommande " +
                    "JOIN articles a       ON lc.codeArticle = a.codeArticle " +
                    "JOIN users u          ON c.idClient = u.id " +
                    "WHERE c.idClient = ? " +
                    "ORDER BY c.numCommande DESC";

    @Override
    public List<CommandeDetailDto> findDetailByIdClient(int idClient) {
        List<CommandeDetailDto> details = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_DETAIL_BY_ID_CLIENT)) {

            ps.setInt(1, idClient);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    details.add(new CommandeDetailDto(
                            rs.getInt("numCommande"),
                            rs.getDate("dateCommande").toLocalDate(),
                            rs.getInt("idClient"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("city"),
                            rs.getString("tel"),
                            rs.getString("reference"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("prix"),
                            rs.getInt("qteCde")
                    ));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching commande details: " + e.getMessage());
        }

        return details;
    }
    @Override
    public List<Commandes> findByIdClient(int idClient) {
        List<Commandes> commandes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_ID_CLIENT)) {

            ps.setInt(1, idClient);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Commandes commande = new Commandes(
                            rs.getInt("numCommande"),
                            rs.getDate("dateCommande").toLocalDate(),
                            rs.getInt("idClient")
                    );
                    commandes.add(commande);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching commandes for idClient " + idClient + ": " + e.getMessage());
        }

        return commandes;
    }

    @Override
    public List<LignesCommande> findByNumCommande(int numCommande) {
        return fetchLignes(FIND_BY_NUM_COMMANDE, numCommande);
    }

    @Override
    public List<LignesCommande> findByCodeArticle(int codeArticle) {
        return fetchLignes(FIND_BY_CODE_ARTICLE, codeArticle);
    }

    // Private helper to avoid duplicating JDBC boilerplate
    private List<LignesCommande> fetchLignes(String query, int param) {
        List<LignesCommande> lignes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, param);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lignes.add(new LignesCommande(
                            rs.getInt("numCommande"),
                            rs.getInt("codeArticle"),
                            rs.getInt("qteCde")
                    ));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching lignescommande: " + e.getMessage());
        }

        return lignes;
    }


    @Override
    public boolean addCommandeWithLigne(int idClient, int codeArticle, int qteCde) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            int numCommande = -1;
            try (PreparedStatement psCommande = conn.prepareStatement(
                    INSERT_COMMANDE, Statement.RETURN_GENERATED_KEYS)) {

                psCommande.setDate(1, Date.valueOf(LocalDate.now()));
                psCommande.setInt(2, idClient);
                psCommande.executeUpdate();

                try (ResultSet generatedKeys = psCommande.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        numCommande = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Failed to retrieve generated numCommande");
                    }
                }
            }

            try (PreparedStatement psLigne = conn.prepareStatement(INSERT_LIGNE_COMMANDE)) {
                psLigne.setInt(1, numCommande);
                psLigne.setInt(2, codeArticle);
                psLigne.setInt(3, qteCde);
                psLigne.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Transaction failed, rolling back: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); }
                catch (SQLException ex) { System.err.println("Rollback failed: " + ex.getMessage()); }
            }
            return false;

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}