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
    <h2>do you want to register</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <form action="register" method="post">
        <label>Email</label>
        <input type="text" name="email" placeholder="Votre email">

        <label>name</label>
        <input type="text" name="name" placeholder="your name">

        <label>Address</label>
        <input type="text" name="address" placeholder="your address">

        <label>ZIP code</label>
        <input type="text" name="zip" placeholder="Zip code">

        <label>city</label>
        <input type="text" name="city" placeholder="city">

        <label>phone number</label>
        <input type="text" name="tel" placeholder="phone number">

        <label>password</label>
        <input type="password" name="password" placeholder="password">

        <button type="submit">register</button>
    </form>

    <a href="auth">already have account ? login</a>
</div>
</body>
</html>