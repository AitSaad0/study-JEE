<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.gestionmagasin.Stock" %>
<html>
<head>
    <title>Commandes partagées</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String method = request.getParameter("method");
    String password = request.getParameter("password");
%>

<jsp:useBean id="client" class="com.example.gestionmagasin.Client" />
<jsp:useBean id="utilisateurs" class="com.example.gestionmagasin.Utilisateurs" scope="application" />

<jsp:setProperty name="client" property="name" param="name" />
<jsp:setProperty name="client" property="password" param="password" />

<%
    if(method != null && name != null && !name.trim().isEmpty()) {

        if(method.equals("inscription")) {
            if(!utilisateurs.clientExiste(name)){
                utilisateurs.ajouterClient(client);
            }
        }

        if(method.equals("commande")){
            if(!utilisateurs.clientExiste(name)){
                response.sendRedirect("identification.jsp?error=errorIdentification");
                return;
            }
        }
    }
%>

<h1>BIENVENUE <%= name %></h1>
<form action="unecommande.jsp" method="get">
    <input name="produit" type="text">
    <button type="submit" name="commander">commander</button>
</form>

<%
    String produit = request.getParameter("produit");
    String[] produit_info = Stock.rechercheParNom(produit);
    if(produit_info != null){

%>
<%= produit_info %>
<%
    }else{
%>
<p>veuillez chercher un produit </p>
<%    }
%>

</body>
</html>