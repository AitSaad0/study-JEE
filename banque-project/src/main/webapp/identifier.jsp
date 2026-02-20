<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/20/26
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>identifier</title>
</head>
<body>
  <form action="identifier" method="post">
    <label> email <input type="text" name="email"></label><br>
    <label> mdp <input type="text" name="mdp"></label><br>
    <button type="submit"> s'inscrir </button>
  </form>
  <% if (request.getAttribute("errorMessage") != null) { %>
  <div style="color:red;">
    <%= request.getAttribute("errorMessage") %>
  </div>
  <% } %>

  <a href="inscrir" > s'inscrir</a>

</body>
</html>
