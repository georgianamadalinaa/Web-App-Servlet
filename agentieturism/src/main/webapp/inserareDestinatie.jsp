<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Destinatie</title>
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
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Fundal alb semi-transparent */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Umbră ușoară pentru un efect mai frumos */
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
        <h2>Add New Destinatie</h2>
        <form action="inserareDestinatie" method="post">
            <label for="idDestinatie">ID Destinatie:</label>
            <input type="number" id="idDestinatie" name="idDestinatie" required><br>

            <label for="taraDes">Tara:</label>
            <input type="text" id="taraDes" name="taraDes" required><br>

            <label for="orasDes">Oras:</label>
            <input type="text" id="orasDes" name="orasDes" required><br>

            <label for="hotelDes">Hotel:</label>
            <input type="text" id="hotelDes" name="hotelDes" required><br>

            <label for="adresaDes">Adresa:</label>
            <input type="text" id="adresaDes" name="adresaDes" required><br>

            <label for="telefonDes">Telefon:</label>
            <input type="text" id="telefonDes" name="telefonDes" required><br>

            <button type="submit">Add Destinatie</button>
        </form>
    </div>

</body>
</html>
