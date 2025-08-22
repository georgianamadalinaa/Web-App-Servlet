<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width">
    <title>Home - Vip Travel</title>
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
        <h2>Realize Your Travel Dreams With Us</h2>
    </div>

    <div class="nav">
        <ul>
            <li><a href="home.jsp" class="active">Home</a></li>
            <li><a href="angajati">Angajati</a></li>
            <li>
                <a href="contract">Contract</a>
                <div class="dropdown">
                    <a href="inserareContract">Inserare</a>                   
                    <a href="searchContract">Căutare</a>
                   
                </div>
            </li>
            <li>
                <a href="destinatie">Destinatie</a>
                <div class="dropdown">
                    <a href="inserareDestinatie">Inserare</a>
                    <a href="searchDestinatie">Căutare</a>
                    
                </div>
            </li>
            <li>
                <a href="client">Client</a>
                <div class="dropdown">
                    <a href="inserare">Inserare</a>
                    <a href="searchClient">Căutare</a>
                    
                </div>
            </li>
        </ul>
    </div>

    <div class="main-content">
        <h3>Our Destinations</h3>
        <div class="content-section">
            <!-- Destinatie 1 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Thailanda</h4>
                <p><img src="thailanda.jpg" alt="Thailanda"></p>
                <p>From $595*</p>
            </div>

            <!-- Destinatie 2 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Bora Bora</h4>
                <p><img src="borabora.jpg" alt="Bora Bora"></p>
                <p>From $1225*</p>
            </div>

            <!-- Destinatie 3 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Maldives</h4>
                <p><img src="maldive.jpg" alt="Maldives"></p>
                <p>From $1599*</p>
            </div>

            <!-- Destinatie 4 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Paris</h4>
                <p><img src="paris.jpg" alt="Paris"></p>
                <p>From $799*</p>
            </div>

            <!-- Destinatie 5 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Santorini</h4>
                <p><img src="santorini.jpg" alt="Santorini"></p>
                <p>From $899*</p>
            </div>

            <!-- Destinatie 6 -->
            <div>
                <h4><span style="color: #f49c42;">Best Price:</span> Tokyo</h4>
                <p><img src="tokyo.jpg" alt="Tokyo"></p>
                <p>From $1050*</p>
            </div>
        </div>

        <h3>Where Do You Plan To Go?</h3>
        <p>Imagine a place where timeless stories come to life magically. Whether you choose a vacation in one of the Disney parks or a magical cruise, everything is designed to make your dreams come true.</p>
        <p><a href="#" class="btn">Read More</a></p>
    </div>

    <div class="footer">
        <p>&copy; 2025 Vip Travel - All Rights Reserved</p>
        <p><a href="logout.jsp" style="color: white;">Logout</a></p>
    </div>

</body>
</html>
