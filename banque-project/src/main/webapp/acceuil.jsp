<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/20/26
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Acceuil</title>
</head>
<body>
    <% String nom = request.getParameter("nom"); %>

    <h1>Bonjour Monsieur <%= nom %></h1>

    <a href="/catalogue">Consulter le  catalogue</a>
    <a href="/catalogue">Suivre mes commandes</a>
    <a href="/catalogue">Visualiser votre panier</a>

</body>
</html>
