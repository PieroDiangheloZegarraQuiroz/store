<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/styles_forms.css"/>
    <title>Register to UnBag</title>
    <link rel="shortcut icon" href="assets/image/logo2.png">
</head>
<body>
<!-- Modal of Success -->
<div class="modal" id="modal">
    <div class="modal-text">
        Registrado con exito.
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
<!-- init logo -->
<section class="tittle">
    <span class="tittle-text">X-PRSS</span>
    <span class="tittle-text">NOVA</span>
</section>
<!-- init form container -->
<section class="container">
    <!-- init title of form -->
    <section class="form-container">
        <h2 class="title-sign" id="title">Registrate en NOVA</h2>
        <!-- init form register -->
        <form action="${pageContext.request.contextPath}/SRegister?action=register" id="form" method="POST">
            <!-- field NAME -->
            <div class="form-field">
                <label for="userName" class="message userName">Nombres</label>
                <input
                        type="text"
                        name="name"
                        id="userName"
                        class="form-field-text"
                        placeholder="Mike lian"
                        maxlength="30"
                        required
                />
            </div>
            <!-- field LASTNAME -->
            <div class="form-field">
                <label for="lastName" class="message lastName">Apellidos</label>
                <input
                        type="text"
                        name="surname"
                        id="lastName"
                        class="form-field-text"
                        placeholder="Smith"
                        required
                />
            </div>
            <!-- field DNI -->
            <div class="form-field">
                <label for="Dni" class="Dni">Documento de Identidad</label>
                <input
                        type="number"
                        name="docIdentity"
                        id="Dni"
                        class="form-field-text"
                        placeholder="88545712"
                        maxlength="8"
                        required
                />
            </div>
            <!-- field EMAIL -->
            <div class="form-field">
                <label for="email" class="email">Email</label>
                <input
                        type="email"
                        name="email"
                        id="email"
                        class="form-field-text"
                        placeholder="example@gmail.com"
                        required
                />
            </div>
            <!-- field PASSWORD -->
            <div class="form-field">
                <label for="password" class="message password">Contraseña</label>
                <input
                        type="password"
                        name="password"
                        id="password"
                        class="form-field-text"
                        required/>
                <span class="view-password"></span>
            </div>
            <!-- field PHONE-NUMBER of user -->
            <div class="form-field">
                <label for="phoneNumber">Número de teléfono</label>
                <input type="number"
                       name="phone"
                       id="phoneNumber"
                       class="form-field-text"
                       placeholder="987 654 321"
                       maxlength="9" required>
            </div>
            <!-- field POLITICS AND PRIVACITY -->
            <div class="form-field privacity">
                <input
                        type="checkbox"
                        name="politics"
                        id="politics"
                        class="form-field-check"
                />
                <label for="politics" class="politics">Acepta nuestras políticas de privacidad</label>
            </div>
            <!-- BUTTON CREATE Account-->
            <button class="submit-Button" id="submit-Button" disabled="true">
                Crear cuenta
            </button>
        </form>
        <!-- LINK TO lOGIN.html -->
        <a class="btn-sign" href="login.jsp" id="btn-sign">Iniciar sesión</a>
    </section>
</section>
<!-- Init JavaScript -->
<script src="scripts/scripts_form.js"></script>
</body>
</html>
