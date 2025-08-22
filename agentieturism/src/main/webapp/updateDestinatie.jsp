<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizare Destinație</title>
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
        <h2>Actualizare Destinație</h2>

        <!-- Formularul de actualizare a destinației -->
        <form action="webapp/updateDestinatie" method="post">
            <input type="hidden" name="idDestinatie" value="${destinatie.idDestinatie}">

            <label for="taraDes">Țara:</label>
            <input type="text" id="taraDes" name="taraDes" value="${destinatie.taraDes}" required><br>

            <label for="orasDes">Oraș:</label>
            <input type="text" id="orasDes" name="orasDes" value="${destinatie.orasDes}" required><br>

            <label for="hotelDes">Hotel:</label>
            <input type="text" id="hotelDes" name="hotelDes" value="${destinatie.hotelDes}" required><br>

            <label for="adresaDes">Adresă:</label>
            <input type="text" id="adresaDes" name="adresaDes" value="${destinatie.adresaDes}" required><br>

            <label for="telefonDes">Telefon:</label>
            <input type="text" id="telefonDes" name="telefonDes" value="${destinatie.telefonDes}" required><br>

            <button type="submit">Actualizează Destinația</button>
        </form>
    </div>

</body>
</html>
