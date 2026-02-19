<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Commandes partagées</title>
</head>
<body>

<%! static List<String> commande_list = Collections.synchronizedList(new ArrayList<>()); %>
<%
    String method = request.getParameter("method");
    String name = request.getParameter("name");

    if(method != null && name != null && !name.trim().isEmpty()) {

        if(method.equals("inscription")) {
            if(!commande_list.contains(name)){
                commande_list.add(name);
            }
        }

        if(method.equals("commande")){
            if(!commande_list.contains(name)){
                response.sendRedirect("identification.jsp?error=errorIdentification");
                return;
            }
        }
        response.sendRedirect("identification.jsp?name=" + name);
    }
%>

</body>
</html>