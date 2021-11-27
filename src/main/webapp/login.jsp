<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/styles_forms.css"/>

    <title>Iniciar Sesión</title>
    <link rel="shortcut icon" href="Assets/Images/logo2.png">
</head>
<body>
<!-- Modal of Success -->
<div class="modal" id="modal">
    <div class="modal-text">
        Logueo exitoso.
    </div>
    <div class="modal-icon" id="modal-icon">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
        </svg>
    </div>
</div>
<!-- btn return home -->
<a href="SHome?action=list" class="back">
    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
              d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1"/>
    </svg>
</a>

<!-- init logo text -->
<section class="tittle">
    <span class="tittle-text">G-BUNDLE</span>
    <span class="tittle-text" style="font-size: 20px">COMMERCE</span>
</section>
<!-- init form container -->
<section class="container">
    <!-- init title of form -->
    <section class="form-container">
        <h2 class="title-sign" id="title">Iniciar Sesión</h2>

        <!-- init form register -->
        <form action="SLogin" method="post">
            <!-- field Email -->
            <div class="form-field">
                <label for="emailHelp" class="email">Email</label>
                <input
                        type="email"
                        name="email"
                        id="emailHelp"
                        class="form-field-text"
                />
            </div>
            <!-- field Password -->
            <div class="form-field">
                <label for="password" class="old-password">Contraseña</label>
                <input
                        type="password"
                        name="password"
                        id="password"
                        class="form-field-text"
                />
                <span class="view-password"></span>
            </div>
            <!-- Button init session -->
            <button class="submit-Button active" type="submit" name="action" value="login">
                Ingresar
            </button>
            <h1><b>${errorLogin}</b></h1>
        </form>

        <a class="btn-sign" href="register.jsp" id="btn-sign">Registrate</a>
    </section>
</section>
<script src="scripts/scripts_form.js"></script>
</body>
</html>
