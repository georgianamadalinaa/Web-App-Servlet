<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizare Client</title>
    <style>
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
    </style>
</head>
<body>

    <div class="container">
        <h2>Actualizare Client</h2>

        <!-- Mesaj de eroare sau succes -->
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>

        <form action="updateClient" method="post">
            <input type="hidden" name="idCnp" value="${client.idCnp}">
            
            <label for="nume">Nume:</label>
            <input type="text" id="nume" name="nume" value="${client.nume}" required><br>

            <label for="prenume">Prenume:</label>
            <input type="text" id="prenume" name="prenume" value="${client.prenume}" required><br>

            <label for="adresa">Adresa:</label>
            <input type="text" id="adresa" name="adresa" value="${client.adresa}" required><br>

            <label for="telefon">Telefon:</label>
            <input type="text" id="telefon" name="telefon" value="${client.telefon}" required><br>

            <button type="submit">Actualizează Client</button>
        </form>
    </div>

</body>
</html>
