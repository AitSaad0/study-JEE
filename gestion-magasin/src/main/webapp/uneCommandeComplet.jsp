<%@ page import="com.example.gestionmagasin.Stock" %>
<%@ page import="java.net.URLEncoder" %>
<table border="1">
    <%
        for(String[] p : Stock.leStock){
    %>
    <tr>
        <td><%= p[0] %> - <%= p[1] %> euro - <%= p[2] %></td>

    </tr>
    <%
        }
    %>


</table>