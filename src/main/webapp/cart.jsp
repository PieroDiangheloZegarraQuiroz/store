<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/tailwind.css">
    <link rel="stylesheet" href="styles/styles_page.css">
    <link rel="stylesheet" href="styles/style_card.css">
    <title>Carrito</title>
    <link rel="shortcut icon" href="assets/image/logo2.png">
</head>
<body>
<!-- init header -->
<img src="img/fondo1.png" style="position: absolute;z-index: -10000;width: 86%;height: 100vh;margin-top: 10vh;">
<header class="main-header flex justify-evenly sm:justify-between container mx-auto" id="navbar" style="border-bottom: #7960CE 5px solid">
    <nav class="flex items-center w-6/12 justify-evenly sm:justify-between nav-header">
        <img src="assets/image/logo2.png" alt="logo" width="60">
        <a href="SHome?action=list" class="hover:text-purple-800 duration-700 transform scale-90 un-active">Principal</a>
        <a href="SStore?action=list" class="hover:text-purple-800 duration-700 transform scale-90 un-active">Productos</a>
        <a href="SCard?action=listCart" class="active">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                 stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"></path>
            </svg>
            Carrito</a>
    </nav>
    <nav class="flex items-center w-6/12 justify-start sm:justify-end nav-header">
        <c:set var="validats" value="${validats}"/>
        <c:if test="${!validats}">
            <a href="login.jsp"
               class="px-10 py-2 border my-3 mx-5 rounded hover:border-purple-700 hover:text-purple-800 duration-700 transform hover:scale-90">Login</a>
            <a href="register.jsp"
               class="px-10 py-2 border my-3 mx-5 rounded hover:border-purple-700 hover:text-purple-800 duration-700 transform hover:scale-90">Registro</a>
        </c:if>
        <c:if test="${validats}">
            <a href="#"
               class="flex px-8 py-2 bg-purple-800 my-3 mx-4 rounded hover:bg-purple-700">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-4" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                </svg>
                    ${nameHome}
            </a>
            <a href="SLogin?action=exit" class="text-red-500 transform hover:scale-110 duration-700">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M13 4.00894C13.0002 3.45665 12.5527 3.00876 12.0004 3.00854C11.4481 3.00833 11.0002 3.45587 11 4.00815L10.9968 12.0116C10.9966 12.5639 11.4442 13.0118 11.9965 13.012C12.5487 13.0122 12.9966 12.5647 12.9968 12.0124L13 4.00894Z"
                          fill="currentColor"></path>
                    <path d="M4 12.9917C4 10.7826 4.89541 8.7826 6.34308 7.33488L7.7573 8.7491C6.67155 9.83488 6 11.3349 6 12.9917C6 16.3054 8.68629 18.9917 12 18.9917C15.3137 18.9917 18 16.3054 18 12.9917C18 11.3348 17.3284 9.83482 16.2426 8.74903L17.6568 7.33481C19.1046 8.78253 20 10.7825 20 12.9917C20 17.41 16.4183 20.9917 12 20.9917C7.58172 20.9917 4 17.41 4 12.9917Z"
                          fill="currentColor"/>
                </svg>
            </a>
        </c:if>
    </nav>
</header>
<!-- Icon view in screen < 640px MOBILE -->
<div class="container-mobile-icon sm:hidden">
    <a href="#" class="mobile-icon" id="open-menu">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
        </svg>
    </a>
    <a href="#" class="mobile-icon hidden" id="closed-menu">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
        </svg>
    </a>
</div>

<a href="#" class="mobile-icon z-10 card" id="closed-form">
    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
    </svg>
</a>
<%--Table of tables--%>
<h1 class="text-sm font-bold mt-8 mb-4 my-6 sm:ml-4 text-center sm:text-left">Tus productos estan aquí</h1>
<section class="relative flex justify-center items-center">
    <!-- All products -->
    <section class="table-product">
        <!-- table header  -->
        <div class="grid-container-card">
            <div class="field text-xs md:text-sm text-card image" style="color: #333">Imagen</div>
            <div class="field text-xs md:text-sm text-card name" style="color: #333">Nombre</div>
            <div class="field text-xs md:text-sm text-card quantity" style="color: #333">Cantidad</div>
            <div class="field text-xs md:text-sm text-card price" style="color: #333">Precio</div>
            <div class="field text-xs md:text-sm text-card subtotal" style="color: #333">Subtotal</div>
            <div class="field text-xs md:text-sm text-card remove" style="color: #333">Eliminar</div>
        </div>
        <!-- row of products -->
        <c:forEach var="itemCard" items="${cardInfos}">
            <div class="grid-container-card">
                <div class="field image">
                    <img src="assets/image/${itemCard.getProduct().getUrlPhoto()}" alt="product" class="w-10">
                </div>
                <div class="field name">${itemCard.getProduct().getName()}</div>
                <div class="field quantity">${itemCard.getQuantity()}</div>
                <div class="field price">S/${itemCard.getProduct().getPrice()}0</div>
                <div class="field subtotal">S/${itemCard.getSubtotal()}0</div>

                <input type="hidden" id="id-product-${itemCard.getProduct().getIdProduct()}"
                       value="${itemCard.getProduct().getIdProduct()}">
                <div onclick="eliminar(${itemCard.getProduct().getIdProduct()})"
                     class="field remove cursor-pointer transform hover:scale-110">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"></path>
                    </svg>
                </div>

            </div>
        </c:forEach>
    </section>

    <!-- Form for credit card and Address -->
    <section class="card-form-container" id="open-card">
        <c:set var="itemCard" value="${cardTotal}"/>
        <h1 class="text-sm text-base lg:text-lg ml-6 lg:ml-10 my-6 text-center sm:text-left" style="color: white">Total a pagar<span
                class="ml-10">S/${itemCard}0</span></h1>
        <div class="credit-card" style="color: white">
            <h5 class="info-card">Mastercard</h5>
            <div class="chip">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-10 w-10" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M9 3v2m6-2v2M9 19v2m6-2v2M5 9H3m2 6H3m18-6h-2m2 6h-2M7 19h10a2 2 0 002-2V7a2 2 0 00-2-2H7a2 2 0 00-2 2v10a2 2 0 002 2zM9 9h6v6H9V9z"></path>
                </svg>
            </div>
            <h5 class="info-card">1234 **** **** 9876</h5>
            <h5 class="info-card">04/21</h5>
            <h5 class="info-card">Mike Smith</h5>
        </div>
        <!-- form of credit card info-->
        <form action="SPay" class="form-card" id="form-card" method="POST">
            <div class="form-field">
                <input class="input-text" type="text" name="cardName" id="cardName" placeholder="Mike Smith" required>
            </div>
            <div class="form-field">
                <input class="input-text" type="text" name="numberCard" id="numberCard"
                       placeholder="xxxx xxxx xxxx xxxx"
                       maxlength="16" required>
            </div>
            <div class="form-field date">
                <input class="input-text" type="date" name="monthCard" id="monthCard" required>
                <!-- <input class="input-text" type="text" name="yearCard" id="yearCard"> -->
                <input class="input-text" type="text" name="cvv" id="cvv" placeholder="CVV" maxlength="3" required>
            </div>

            <!-- FORM OF DELIVERY AND ADDRESS INFO -->
            <!-- Departments Valid -->
            <div class="form-field">
                <label for="department" class="text-sm font-bold mx-1 my-5 text-left">Servicio de delivery disponible
                    para:</label>
                <select name="departamento" id="department" class="input-text" aria-readonly="true">
                    <option value="default">
                        Departamento de Lima
                    </option>
                </select>
            </div>
            <!-- Province Valid -->
            <div class="form-field">
                <select name="provincia" id="provided" class="input-text" aria-readonly="true">
                    <option value="default">
                        Provincia de Lima
                    </option>
                </select>
            </div>
            <!-- Districts valid -->

            <div class="form-field">
                <select name="idDistrict" id="districts" class="input-text" required>
                    <option value="0">
                        Escoga su Distrito
                    </option>
                    <option value="1">
                        Villa el salvador
                    </option>
                    <option value="2">
                        San Juan de Miraflores
                    </option>
                    <option value="3">
                        Santiago de surco
                    </option>
                    <option value="4">
                        Cercado de Lima
                    </option>
                    <option value="5">
                        Chorrillos
                    </option>
                </select>
            </div>
            <!--  Direction insert the user-->
            <div class="form-field">
                <input type="text" name="address" id="direction" placeholder="Ingresa tu dirección aqui"
                       maxlength="45" class="input-text" required>
            </div>
            <div class="form-field">
                <input type="submit" value="Pagar ahora" class="btn-pay">
            </div>
        </form>
    </section>
</section>
<a href="#" id="add-card" class="add-card flex lg:hidden">
    Comprar ahora
</a>


<script src="scripts/validCreditCard.js"></script>
<script src="scripts/animations.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="scripts/funciones.js" type="text/javascript"></script>
</body>
</html>
