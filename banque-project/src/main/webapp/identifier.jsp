<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Identifier</title>
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

    .login-container {
      background-color: #fff;
      padding: 40px 50px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      width: 100%;
      max-width: 400px;
      text-align: center;
    }

    .login-container h2 {
      margin-bottom: 30px;
      color: #333;
    }

    .login-container label {
      display: block;
      text-align: left;
      margin-bottom: 10px;
      color: #555;
      font-weight: bold;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
      width: 100%;
      padding: 10px 12px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 1rem;
    }

    .login-container button {
      width: 100%;
      padding: 12px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .login-container button:hover {
      background-color: #0056b3;
    }

    .error-message {
      color: red;
      margin-bottom: 15px;
    }

    .login-container a {
      display: inline-block;
      margin-top: 15px;
      text-decoration: none;
      color: #007bff;
    }

    .login-container a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="login-container">
  <h2>Se connecter</h2>
  <% if (request.getAttribute("errorMessage") != null) { %>
  <div class="error-message">
    <%= request.getAttribute("errorMessage") %>
  </div>
  <% } %>
  <form action="identifier" method="post">
    <label>Email</label>
    <input type="text" name="email" placeholder="Votre email">

    <label>Mot de passe</label>
    <input type="password" name="mdp" placeholder="Votre mot de passe">

    <button type="submit">S'identifier</button>
  </form>
  <a href="inscrir">S'inscrire</a>
</div>
</body>
</html>