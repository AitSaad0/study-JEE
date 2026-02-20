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

    <h1>Bonjour Monsieur ${sessionScope.client.nom()}</h1>

    <a href="/catalogue">Consulter le  catalogue</a> <br><br>
    <a href="/catalogue">Suivre mes commandes</a><br><br>
    <a href="/catalogue">Visualiser votre panier</a>

</body>
</html>
