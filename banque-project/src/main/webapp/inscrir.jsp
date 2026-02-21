<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S'inscrire</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .register-container {
            background-color: #fff;
            padding: 40px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 450px;
            text-align: center;
        }

        .register-container h2 {
            margin-bottom: 30px;
            color: #333;
        }

        .register-container label {
            display: block;
            text-align: left;
            margin-bottom: 10px;
            color: #555;
            font-weight: bold;
        }

        .register-container input[type="text"],
        .register-container input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        .register-container button {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .register-container button:hover {
            background-color: #218838;
        }

        .error-message {
            color: red;
            margin-bottom: 15px;
        }

        .register-container a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
        }

        .register-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="register-container">
    <h2>Créer un compte</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <form action="inscrir" method="post">
        <label>Email</label>
        <input type="text" name="email" placeholder="Votre email">

        <label>Nom</label>
        <input type="text" name="nom" placeholder="Votre nom">

        <label>Adresse</label>
        <input type="text" name="adresse" placeholder="Votre adresse">

        <label>Code postal</label>
        <input type="text" name="codePostal" placeholder="Code postal">

        <label>Ville</label>
        <input type="text" name="ville" placeholder="Ville">

        <label>Téléphone</label>
        <input type="text" name="tel" placeholder="Numéro de téléphone">

        <label>Mot de passe</label>
        <input type="password" name="mdp" placeholder="Mot de passe">

        <button type="submit">S'inscrire</button>
    </form>

    <a href="identifier">Déjà inscrit ? Se connecter</a>
</div>
</body>
</html>