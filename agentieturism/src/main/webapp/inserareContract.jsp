<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Contract</title>
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
        input, select {
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
        <h2>Add New Contract</h2>
        <form action="inserareContract" method="post">
            <label for="nrContract">Nr. Contract:</label>
            <input type="number" id="nrContract" name="nrContract" required><br>

            <label for="idAngajat">ID Angajat:</label>
            <input type="number" id="idAngajat" name="idAngajat" required><br>

            <label for="codCnp">CNP Client:</label>
            <input type="text" id="codCnp" name="codCnp" required><br>

            <label for="idDestinatie">ID Destinație:</label>
            <input type="number" id="idDestinatie" name="idDestinatie" required><br>

            <label for="dataPlecare">Data Plecare:</label>
            <input type="date" id="dataPlecare" name="dataPlecare" required><br>

            <label for="nrNopti">Număr Nopți:</label>
            <input type="number" id="nrNopti" name="nrNopti" required><br>

            <label for="transport">Transport:</label>
            <select id="transport" name="transport" required>
                <option value="avion">Avion</option>
                <option value="autobuz">Autobuz</option>
                <option value="tren">Tren</option>
                <option value="masina">Mașină</option>
            </select><br>

            <label for="sumaPlata">Suma de Plată:</label>
            <input type="number" id="sumaPlata" name="sumaPlata" step="0.01" required><br>

            <button type="submit">Add Contract</button>
            <a href="addContract?action=graf">
    <button>Vezi Graficul Contractelor</button>
</a>
        </form>
    </div>

</body>
</html>
