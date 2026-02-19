<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/18/26
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Identification</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        if(name == null){
            name = "user";
        }
    %>
    <h1> Bienvenue <%= name %> </h1>
    <h3>formulaire d'inscription</h3>
    <form action="unecommande.jsp"  method="post">
        <label>name
            <input name="name" type="text">
        </label>
        <label> password
            <input name="password" type="text">
        </label>
        <button name="method" value="inscription" type="submit">inscription</button>
        <button name="method" value="commande" type="submit">commander</button>
    </form>



    <%
        String error = request.getParameter("error");
    %>

    <% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
    <% } %>

</body>
</html>
