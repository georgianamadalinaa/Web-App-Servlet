<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">
    <title>Angajati - Vip Travel</title>
    <link rel="stylesheet" href="resources/css/style.css" media="screen">
    <link rel="stylesheet" href="resources/css/style.responsive.css" media="all">
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/script.js"></script>
    <script src="resources/js/script.responsive.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #333;
            color: white;
            padding: 15px;
            text-align: center;
        }
        .header a {
            color: white;
            text-decoration: none;
            padding: 10px;
            font-size: 20px;
        }
        .header a:hover {
            background-color: #575757;
        }
        .nav {
            text-align: center;
            background-color: #333;
            position: relative;
        }
        .nav ul {
            list-style-type: none;
            padding: 0;
        }
        .nav ul li {
            display: inline-block;
            padding: 10px;
            position: relative;
        }
        .nav ul li a {
            color: white;
            text-decoration: none;
        }
        .nav ul li a:hover {
            background-color: #575757;
            border-radius: 5px;
        }
        .nav ul li:hover .dropdown {
            display: block;
        }
        .dropdown {
            display: none;
            position: absolute;
            background-color: #333;
            min-width: 160px;
            z-index: 1;
            top: 100%;
            left: 0;
        }
        .dropdown a {
            color: white;
            padding: 10px;
            text-decoration: none;
            display: block;
        }
        .dropdown a:hover {
            background-color: #575757;
        }
        .main-content {
            padding: 20px;
            background-color: #fff;
        }
        .btn {
            background-color: #f49c42;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            margin: 10px 0;
        }
        .btn:hover {
            background-color: #e6892d;
        }
        .content-section {
            display: grid;
            grid-template-columns: repeat(3, 1fr); /* Trei coloane */
            gap: 20px;
            margin-top: 30px;
        }
        .content-section div {
            background-color: #f9f9f9;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }
        .content-section img {
            max-width: 100%;
            border-radius: 5px;
        }
        .footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 40px;
        }
    </style>
</head>
<body>

    <div class="header">
        <h1>Welcome, <%= session.getAttribute("user") %>!</h1>
        <h2>Manage Employees and More</h2>
    </div>

    <div class="nav">
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="angajati" class="active">Angajati</a></li>
            <li>
                <a href="contract">Contract</a>
                <div class="dropdown">
                    <a href="inserareContract">Inserare</a>
                    <a href="modificare">Modificare</a>
                    <a href="stergeContract">Stergere</a>
                </div>
            </li>
            <li>
                <a href="destinatie">Destinatie</a>
                <div class="dropdown">
                    <a href="inserareDestinatie">Inserare</a>
                    <a href="modificare">Modificare</a>
                    <a href="sterge">Stergere</a>
                </div>
            </li>
            <li>
                <a href="client">Client</a>
                <div class="dropdown">
                    <a href="inserare">Inserare</a>
                    <a href="searchclient">Modificare</a>
                    <a href="stergeClient">Stergere</a>
                </div>
            </li>
        </ul>
    </div>

    <div class="main-content">
        <h3>Employee List</h3>
        <p>Below is a list of all employees working at Vip Travel.</p>
        
        <div class="content-section">
            <!-- Exemplu angajat 1 -->
            <div>
                <h4>John Doe</h4>
                <p><strong>Role:</strong> Travel Agent</p>
                <p><strong>Email:</strong> johndoe@example.com</p>
                <p><strong>Phone:</strong> +1234567890</p>
            </div>

            <!-- Exemplu angajat 2 -->
            <div>
                <h4>Jane Smith</h4>
                <p><strong>Role:</strong> Tour Manager</p>
                <p><strong>Email:</strong> janesmith@example.com</p>
                <p><strong>Phone:</strong> +0987654321</p>
            </div>

            <!-- Exemplu angajat 3 -->
            <div>
                <h4>Bob Johnson</h4>
                <p><strong>Role:</strong> Customer Support</p>
                <p><strong>Email:</strong> bobjohnson@example.com</p>
                <p><strong>Phone:</strong> +1122334455</p>
            </div>
        </div>

        <p><a href="inserareAngajat.jsp" class="btn">Add New Employee</a></p>
    </div>

    <div class="footer">
        <p>&copy; 2025 Vip Travel - All Rights Reserved</p>
        <p><a href="/logout.jsp" style="color: white;">Logout</a></p>
    </div>

</body>
</html>
