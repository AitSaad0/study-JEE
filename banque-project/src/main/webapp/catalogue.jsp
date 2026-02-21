<%@ page import="java.util.List" %>
<%@ page import="com.example.banqueproject.entity.Categories" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.security.Principal" %>
<%@ page import="com.example.banqueproject.dto.PrintedArticleDto" %><%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/20/26
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Catalogue Catégorie</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; color: #333; }
        h1 { color: #2c3e50; border-bottom: 2px solid #eee; padding-bottom: 10px; }

        .filter-section { margin-bottom: 30px; background: #f9f9f9; padding: 15px; border-radius: 8px; }
        label { font-weight: bold; margin-right: 10px; }
        select { padding: 5px; margin-right: 20px; border-radius: 4px; }

        table { width: 100%; border-collapse: collapse; margin-top: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f4f4f4; }

        tr:hover { background-color: #f1f1f1; }

        .btn-panier {
            background-color: #27ae60;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 0.9em;
        }
        .btn-panier:hover { background-color: #2ecc71; }

        .book-img { width: 50px; height: auto; border-radius: 3px; }
    </style>
</head>
<body>
<h1>Bienvenue ${sessionScope.client.nom()} </h1>
<h2>Catégorie</h2>

<%
    List<Categories> listeCategories  = (ArrayList<Categories>)request.getSession().getAttribute("categories") ;
    List<PrintedArticleDto> articles = (List<PrintedArticleDto>) session.getAttribute("printedArticles");
%>
<div class="filter-section">
    <label for="genre">Choisir le categorie :</label>
    <form action="catalogue" method="get">
        <select id="genre" name="category">
            <option value="">-- Toutes les catégories --</option>
            <option value="all">All</option>
            <% for (Categories c : listeCategories) { %>
            <option value="<%= c.getIdCat() %>"><%= c.getCat() %></option>
            <% } %>
        </select>

        <button type="submit">Filtrer</button>
    </form>
</div>

<table>
    <thead>
    <tr>
        <th>Référence</th>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Photo</th>
        <th>Prix</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        for(PrintedArticleDto article : articles) {
    %>
    <tr>
        <td> <a href="catalogue"><%= article.reference()%></a></td>
        <td><%= article.titre()%></td>
        <td><%= article.auteur()%></td>
        <td><%= article.photo()%></td>
        <td><%= article.prix()%></td>
        <td><a href="ajouter?id=001" class="btn-panier">Ajouter au panier</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>

