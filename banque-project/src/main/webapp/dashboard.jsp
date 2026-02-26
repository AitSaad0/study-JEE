<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <style>
        /* Reset simple */
        body, h1, a {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f6f8;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 40px;
            font-size: 2.5rem;
        }

        a {
            display: inline-block;
            margin: 10px 0;
            padding: 12px 25px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
        }

        a:active {
            background-color: #004080;
        }
    </style>
</head>
<body>

<h1>Bonjour Monsieur ${sessionScope.user.name()}</h1>

<a href="catalogue">Consulter le catalogue</a>
<a href="/commandes">Suivre mes commandes</a>
<a href="/panier">Visualiser votre panier</a>

</body>
</html>