<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizare Contract</title>
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
        <h2>Actualizare Contract</h2>

        <!-- Formularul pentru actualizarea contractului -->
        <form action="updateContract" method="post">
            <input type="hidden" name="nrContract" value="${contract.nrContract}">
            
            <label for="idAngajat">ID Angajat:</label>
            <input type="text" id="idAngajat" name="idAngajat" value="${contract.idAngajat}" required><br>

            <label for="codCnp">Cod CNP:</label>
            <input type="text" id="codCnp" name="codCnp" value="${contract.codCnp}" required><br>

            <label for="idDestinatie">ID Destinație:</label>
            <input type="text" id="idDestinatie" name="idDestinatie" value="${contract.idDestinatie}" required><br>

            <label for="dataPlecare">Data Plecare:</label>
            <input type="text" id="dataPlecare" name="dataPlecare" value="${contract.dataPlecare}" required><br>

            <label for="nrNopti">Număr Nopți:</label>
            <input type="text" id="nrNopti" name="nrNopti" value="${contract.nrNopti}" required><br>

            <label for="transport">Transport:</label>
            <input type="text" id="transport" name="transport" value="${contract.transport}" required><br>

            <label for="sumaPlata">Sumă Plata:</label>
            <input type="text" id="sumaPlata" name="sumaPlata" value="${contract.sumaPlata}" required><br>

            <button type="submit">Actualizează Contract</button>
        </form>
    </div>

</body>
</html>
