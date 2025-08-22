<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        /* Stil pentru centrul paginii */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: url('image.jpg'); 
            background-size: cover;
            font-family: Arial, sans-serif;
        }

        /* Stil pentru containerul formularului */
        .login-container {
            background-color: rgba(255, 255, 255, 0.8); /* Fundal semi-transparent */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 300px;
            text-align: center;
        }

        /* Stil pentru etichete și inputuri */
        label {
            font-size: 16px;
            display: block;
            margin-bottom: 5px;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        /* Stil pentru butonul de login */
        button {
            background-color: #4CAF50; /* Culoare verde */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
        }

        /* Stil pentru mesajul de eroare */
        .error-message {
            color: red;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="user">User:</label>
            <input type="text" id="user" name="user" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <button type="submit">Login</button>
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Invalid credentials. Please try again.</p>
        <% } %>
    </div>
</body>
</html>
