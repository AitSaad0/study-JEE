<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/20/26
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>s'inscrir</title>
</head>
<body>
    <form action="inscrir" method="post">

        <label> email <input type="text" name="email"></label><br>
        <label> nom <input type="text" name="nom"></label><br>
        <label> adresse <input type="text" name="adresse"></label><br>
        <label> codePostal <input type="text" name="codePostal"></label><br>
        <label> ville <input type="text" name="ville"></label><br>
        <label> tel <input type="text" name="tel"></label><br>
        <label> mdp <input type="text" name="mdp"></label><br>
        <button type="submit"> s'inscrir </button>
    </form>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div style="color:red;">
        <%= request.getAttribute("errorMessage") %>
    </div> <br><br>
    <% } %>

    <a href="identifier" > authentifier</a>
</body>
</html>
