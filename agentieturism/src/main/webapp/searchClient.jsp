<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Căutare Client</title>
    <style>
        /* Stiluri pentru pagina de căutare */
        body {
            font-family: Arial, sans-serif;
            background-image: url('fundal.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            margin-top: 50px;
            border-radius: 10px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Căutare Client</h2>

        <!-- Mesaj de eroare (dacă există) -->
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>

        <!-- Formularul de căutare a clientului -->
        <form action="searchClient" method="get">
            <label for="idCnp">CNP:</label>
            <input type="text" id="idCnp" name="idCnp" required>
            <button type="submit">Căutare Client</button>
        </form>
        <form action="searchClient" method="post">
            <input type="hidden" name="idCnp" value="${client.idCnp}" />
            <button type="submit" class="delete-button" onclick="return confirm('Esti sigur ca vrei sa stergi acest client?')">Șterge Client</button>
        </form>
    </div>

</body>
</html>
