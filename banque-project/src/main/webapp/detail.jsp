<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/21/26
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Détail de l'article</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #d9e3f0;
            display: flex;
            justify-content: center;
            padding-top: 50px;
        }

        .detail-container {
            background-color: #d9e3f0;
            border: 1px solid #ccc;
            padding: 30px;
            width: 600px;
            box-sizing: border-box;
            text-align: left;
            position: relative;
        }

        h1 {
            text-align: center;
            color: #d91acc;
            font-family: "Comic Sans MS", cursive, sans-serif;
        }

        .article-img {
            float: left;
            margin-right: 20px;
            width: 120px;
            height: 120px;
            object-fit: cover;
            border: 1px solid #aaa;
        }

        .form-group {
            margin-bottom: 10px;
            font-size: 14px;
            color: #5a2e9c;
        }

        .form-group label {
            display: inline-block;
            width: 120px;
        }

        .form-group input {
            padding: 3px 5px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .price-input {
            color: red;
        }

        .actions {
            margin-top: 20px;
            font-size: 13px;
        }

        .actions a {
            text-decoration: underline;
            color: #5a2e9c;
            margin-right: 20px;
        }

        .clear {
            clear: both;
        }
    </style>
</head>
<body>

<div class="detail-container">
    <h1>Détail de l'article</h1>

    <img src="https://via.placeholder.com/120" alt="Article" class="article-img">

    <div class="form-group">
        <label>Année :</label>
        <input type="text" value="1982">
    </div>

    <div class="form-group">
        <label>Référence :</label>
        <input type="text" value="JZ001">
        <label style="width: 50px;">Titre :</label>
        <input type="text" value="Tutu">
    </div>

    <div class="form-group">
        <label>Auteur :</label>
        <input type="text" value="Miles Davies">
        <label style="width: 50px;">Editeur :</label>
        <input type="text" value="Polygram">
    </div>

    <div class="form-group">
        <label>Quantité en stock :</label>
        <input type="text" value="4">
        <label style="width: 50px;">Prix :</label>
        <input type="text" class="price-input" value="120,0000">
    </div>

    <div class="clear"></div>

    <div class="actions">
        <a href="#">Retour</a>
        <a href="#">Ajouter au panier</a>
    </div>
</div>

</body>
</html>