<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/tailwind.css">
    <link rel="stylesheet" href="styles/styles_page.css">
    <title>Productos</title>
    <link rel="shortcut icon" href="assets/image/logo2.png">
    <style>
        *{
            scroll-behavior: smooth;
        }
    </style>
</head>
<body>
<header class="main-header flex justify-evenly sm:justify-between container mx-auto" id="navbar">
    <nav class="flex items-center w-6/12 justify-evenly sm:justify-between nav-header">
        <img src="assets/image/logo2.png" alt="logo" width="60">
        <a href="SHome?action=list" class="hover:text-purple-800 duration-700 transform scale-90 un-active">Principal</a>
        <a href="SStore?action=list" class="active">Productos</a>
        <!--<a href="#" class="hover:text-purple-800 duration-700 transform scale-90 un-active">Shop</a>*/-->
        <a href="SCard?action=listCart" class="flex hover:text-purple-800 duration-700"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
        </svg>
            Carrito</a>
    </nav>
    <nav class="flex items-center w-6/12 justify-start sm:justify-end nav-header">
        <c:set var="validats"  value="${validats}"/>
        <c:if test="${!validats}">
            <a href="login.jsp" class="px-10 py-2 border my-3 mx-5 rounded hover:border-purple-700 hover:text-purple-800 duration-700 transform hover:scale-90">Login</a>
            <a href="register.jsp" class="p-5 px-10 py-2 bg-purple-800 my-3 mx-5 rounded transform hover:scale-110 duration-700">Registro</a>
        </c:if>
        <c:if test="${validats}">
            <a href="${pageContext.request.contextPath}/ServletUsuario?accion=editar&idCliente=${idCliente}" class="flex px-8 py-2 bg-purple-800 my-3 mx-4 rounded hover:bg-purple-700" href="idCliente=${idCliente}&direccion=${direccion}&idDistrito=${idDistrito}">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-4" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                </svg>
                    ${nameHome}
            </a>
            <a href="SLogin?action=exit" class="text-red-500 transform hover:scale-110 duration-700">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M13 4.00894C13.0002 3.45665 12.5527 3.00876 12.0004 3.00854C11.4481 3.00833 11.0002 3.45587 11 4.00815L10.9968 12.0116C10.9966 12.5639 11.4442 13.0118 11.9965 13.012C12.5487 13.0122 12.9966 12.5647 12.9968 12.0124L13 4.00894Z" fill="currentColor"></path><path d="M4 12.9917C4 10.7826 4.89541 8.7826 6.34308 7.33488L7.7573 8.7491C6.67155 9.83488 6 11.3349 6 12.9917C6 16.3054 8.68629 18.9917 12 18.9917C15.3137 18.9917 18 16.3054 18 12.9917C18 11.3348 17.3284 9.83482 16.2426 8.74903L17.6568 7.33481C19.1046 8.78253 20 10.7825 20 12.9917C20 17.41 16.4183 20.9917 12 20.9917C7.58172 20.9917 4 17.41 4 12.9917Z" fill="currentColor" /></svg>
            </a>
        </c:if>
    </nav>
</header>
<!-- Icon view in screen < 640px MOBILE -->
<div class="container-mobile-icon">
    <a href="#" class="mobile-icon" id="open-menu">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
        </svg>
    </a>
    <a href="#" class="mobile-icon hidden" id="closed-menu" >
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
        </svg>
    </a>
</div>
<!-- Show categories -->
<section class="grid-container container mx-auto">
    <a class="category sound"  href="#Sound"></a>
    <a class="category keyboard"  href="#Keyboard"></a>
    <a class="category mouse"  href="#Mouse"></a>
    <a class="category print"  href="#Print"></a>
    <a class="category processor" href="#CPU" ></a>
</section>
<!-- Categorie CPU -->
<h2 class="category-title" id="CPU" >Procesadores</h2>
<section class="category-container gap-1 sm:gap-2 md:gap-4" >
    <%-- Modal add product --%>
    <div class="modal-add-product flex justify-evenly items-center p-4" id="modal-add-product">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 absolute top-2 right-2 cursor-pointer" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
        </svg>
        <img class="w-12" src="#" alt="image product" id="image-product-modal">
        <p class="text-sm" id="name-product-modal"></p>
    </div>
    <!-- card of products -->
    <c:forEach var="processor" items="${processor}">
        <div class="card-product w-40 h-60 md:w-60 md:h-80">
            <input type="hidden" id="id-product-${processor.getIdProduct()}" value="${processor.getIdProduct()}">
            <a onclick="btnAdd(${processor.getIdProduct()}, '${processor.getName()}', '${processor.getUrlPhoto()}', '${processor.getStock()}')" class="btn-add-product p-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                </svg>
            </a>
            <a href="ServletDescription?Name=${processor.getName()}&IdProduct=${processor.getIdProduct()}&Price=${String.valueOf(processor.getPrice())}&Description=${processor.getDescription()}&stock=${processor.getStock()}&UrlPhoto=assets/image/${processor.getUrlPhoto()}">
            <img src="assets/image/${processor.getUrlPhoto()}" alt="product image" class="w-36 transform duration-700 hover:scale-125 hover:rotate-12 cursor-pointer">
            </a>
            <!-- comment<img src="/Oficial/assets/image/head_set_pink.webp" alt="product image" class="w-24 md:w-36 transform duration-700 hover:scale-125 hover:rotate-12">  -->
            <div class="text-base text-gray-400 absolute bottom-2 left-5">
                <div class="name-product font-bold">
                        ${processor.getName()}
                </div>
                <div class="text-xs">
                    Stock: ${processor.getStock()}
                </div>
                <div class="price-product">
                    S/. ${processor.getPrice()} 0
                </div>
            </div>
        </div>
    </c:forEach>
</section>

<!-- Categorie HEADSETS -->
<h2 class="category-title" id="Sound">Sonido</h2>
<section class="category-container gap-1 sm:gap-2 md:gap-4">

    <div class="modal-add-product flex justify-evenly items-center p-4" id="modal-add-product">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 absolute top-2 right-2 cursor-pointer" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
        </svg>
        <img class="w-12" src="#" alt="image product" id="image-product-modal">
        <p class="text-sm" id="name-product-modal"></p>
    </div>
    <!-- card of products -->
    <c:forEach var = "sound" items="${sound}">
        <div class="card-product w-40 h-60 md:w-60 md:h-80">
            <input type="hidden" id="id-product-${sound.getIdProduct()}" value="${sound.getIdProduct()}">
            <a onclick="btnAdd(${sound.getIdProduct()}, '${sound.getName()}', '${sound.getUrlPhoto()}', '${sound.getStock()}')" class="btn-add-product p-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                </svg>
            </a>
            <a href="ServletDescription?Name=${sound.getName()}&IdProduct=${sound.getIdProduct()}&Price=${String.valueOf(sound.getPrice())}&Description=${sound.getDescription()}&stock=${sound.getStock()}&UrlPhoto=assets/image/${sound.getUrlPhoto()}">
                <img src="assets/image/${sound.getUrlPhoto()}" alt="product image" class="w-36 transform duration-700 hover:scale-125 hover:rotate-12 cursor-pointer">
            </a>
            <!-- comment<img src="/Oficial/assets/image/head_set_pink.webp" alt="product image" class="w-24 md:w-36 transform duration-700 hover:scale-125 hover:rotate-12">  -->
            <div class="text-base text-gray-400 absolute bottom-2 left-5">
                <div class="name-product font-bold">
                        ${sound.getName()}
                </div>
                <div class="text-xs">
                    Stock: ${sound.getStock()}
                </div>
                <div class="price-product">
                    S/. ${sound.getPrice()} 0
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- here add all products -->
</section>

<!-- Categorie keyboard -->
<h2 class="category-title" id="Keyboard">Teclados</h2>
<section class="category-container gap-1 sm:gap-2 md:gap-4">
    <div class="modal-add-product flex justify-evenly items-center p-4" id="modal-add-product">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 absolute top-2 right-2 cursor-pointer" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
        </svg>
        <img class="w-12" src="#" alt="image product" id="image-product-modal">
        <p class="text-sm" id="name-product-modal"></p>
    </div>
    <!-- card of products -->
    <c:forEach var="keyboard" items ="${keyboard}">
        <div class="card-product w-40 h-60 md:w-60 md:h-80">
            <input type="hidden" id="id-product-${keyboard.getIdProduct()}" value="${keyboard.getIdProduct()}">
            <a onclick="btnAdd(${keyboard.getIdProduct()}, '${keyboard.getName()}', '${keyboard.getUrlPhoto()}', '${keyboard.getStock()}')" class="btn-add-product p-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                </svg>
            </a>
            <a href="ServletDescription?Name=${keyboard.getName()}&IdProduct=${keyboard.getIdProduct()}&Price=${String.valueOf(keyboard.getPrice())}&Description=${keyboard.getDescription()}&stock=${keyboard.getStock()}&UrlPhoto=assets/image/${keyboard.getUrlPhoto()}">
                <img src="assets/image/${keyboard.getUrlPhoto()}" alt="product image" class="w-36 transform duration-700 hover:scale-125 hover:rotate-12 cursor-pointer">
            </a>
            <!-- comment<img src="/Oficial/assets/image/head_set_pink.webp" alt="product image" class="w-24 md:w-36 transform duration-700 hover:scale-125 hover:rotate-12">  -->
            <div class="text-base text-gray-400 absolute bottom-2 left-5">
                <div class="name-product font-bold">
                        ${keyboard.getName()}
                </div>
                <div class="text-xs">
                    Stock: ${keyboard.getStock()}
                </div>
                <div class="price-product">
                    S/. ${keyboard.getPrice()} 0
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- here add all products -->
</section>

<!-- Categorie gaming -->
<h2 class="category-title" id="Mouse">Mouse</h2>
<section class="category-container gap-1 sm:gap-2 md:gap-4">
    <div class="modal-add-product flex justify-evenly items-center p-4" id="modal-add-product">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 absolute top-2 right-2 cursor-pointer" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
        </svg>
        <img class="w-12" src="#" alt="image product" id="image-product-modal">
        <p class="text-sm" id="name-product-modal"></p>
    </div>
    <!-- card of products -->
    <c:forEach var="mouse" items ="${mouse}">
        <div class="card-product w-40 h-60 md:w-60 md:h-80">
            <input type="hidden" id="id-product-${mouse.getIdProduct()}" value="${mouse.getIdProduct()}">
            <a onclick="btnAdd(${mouse.getIdProduct()}, '${mouse.getName()}', '${mouse.getUrlPhoto()}', '${mouse.getStock()}')" class="btn-add-product p-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                </svg>
            </a>
            <a href="ServletDescription?Name=${mouse.getName()}&IdProduct=${mouse.getIdProduct()}&Price=${String.valueOf(mouse.getPrice())}&Description=${mouse.getDescription()}&stock=${mouse.getStock()}&UrlPhoto=assets/image/${mouse.getUrlPhoto()}">
                <img src="assets/image/${mouse.getUrlPhoto()}" alt="product image" class="w-36 transform duration-700 hover:scale-125 hover:rotate-12 cursor-pointer">
            </a>
            <!-- comment<img src="/Oficial/assets/image/head_set_pink.webp" alt="product image" class="w-24 md:w-36 transform duration-700 hover:scale-125 hover:rotate-12">  -->
            <div class="text-base text-gray-400 absolute bottom-2 left-5">
                <div class="name-product font-bold">
                        ${mouse.getName()}
                </div>
                <div class="text-xs">
                    Stock: ${mouse.getStock()}
                </div>
                <div class="price-product">
                    S/. ${mouse.getPrice()} 0
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- here add all products -->
</section>

<!-- Categorie Articles -->
<h2 class="category-title" id="Print">Impresoras</h2>
<section class="category-container gap-1 sm:gap-2 md:gap-4">
    <div class="modal-add-product flex justify-evenly items-center p-4" id="modal-add-product">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 absolute top-2 right-2 cursor-pointer" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
        </svg>
        <img class="w-12" src="#" alt="image product" id="image-product-modal">
        <p class="text-sm" id="name-product-modal"></p>
    </div>
    <!-- card of products -->
    <c:forEach var="print" items="${print}">
        <div class="card-product w-40 h-60 md:w-60 md:h-80">
            <input type="hidden" id="id-product-${print.getIdProduct()}" value="${print.getIdProduct()}">
            <a onclick="btnAdd(${print.getIdProduct()}, '${print.getName()}', '${print.getUrlPhoto()}', '${print.getStock()}')" class="btn-add-product p-4">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                </svg>
            </a>
            <a href="ServletDescription?Name=${print.getName()}&IdProduct=${print.getIdProduct()}&Price=${String.valueOf(print.getPrice())}&Description=${print.getDescription()}&stock=${print.getStock()}&UrlPhoto=assets/image/${print.getUrlPhoto()}">
                <img src="assets/image/${print.getUrlPhoto()}" alt="product image" class="w-36 transform duration-700 hover:scale-125 hover:rotate-12 cursor-pointer">
            </a>
            <!-- comment<img src="/Oficial/assets/image/head_set_pink.webp" alt="product image" class="w-24 md:w-36 transform duration-700 hover:scale-125 hover:rotate-12">  -->
            <div class="text-base text-gray-400 absolute bottom-2 left-5">
                <div class="name-product font-bold">
                        ${print.getName()}
                </div>
                <div class="text-xs">
                    Stock: ${print.getStock()}
                </div>
                <div class="price-product">
                    S/. ${print.getPrice()} 0
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- here add all products -->
</section>
<script src="scripts/animations.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="scripts/send_datas.js"></script>
</body>
</html>
