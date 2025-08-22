<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Client</title>
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
        <h2>Add New Client</h2>
        <form action="inserare" method="post">
            <label for="idCnp">CNP:</label>
            <input type="text" id="idCnp" name="idCnp" required><br>

            <label for="nume">Name:</label>
            <input type="text" id="nume" name="nume" required><br>

            <label for="prenume">Prenume:</label>
            <input type="text" id="prenume" name="prenume" required><br>

            <label for="adresa">Adresa:</label>
            <input type="text" id="adresa" name="adresa" required><br>

            <label for="telefon">Telefon:</label>
            <input type="text" id="telefon" name="telefon" required><br>

            <button type="submit">Add Client</button>
        </form>
        <form action="inserare" method="get">
    <label for="idCnpForPdf">Introduceti ID CNP pentru PDF:</label>
    <input type="text" id="idCnpForPdf" name="idCnpForPdf" required><br>
    <button type="submit">Generează PDF</button>
</form>
    </div>

</body>
</html>
