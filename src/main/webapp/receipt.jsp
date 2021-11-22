<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/style_recibo.css" />
    <title>Title</title>
    <style>
        :root {
            --shadow:0 25px 50px -12px rgba(0, 0, 0, 0.25);
            --ring-offset-shadow:0 0 #0000;
            --ring-shadow:0 0 #0000;
        }

        .card_open {
            animation-duration: 2s;
            animation-name: card_open;
        }

        @keyframes card_open {
            from {
                height: 1%;
                box-shadow: var(--shadow);
            }

            to {
                height: 100%;
                box-shadow: var(--ring-offset-shadow,0 0 #0000),var(--ring-shadow,0 0 #0000),var(--shadow);
            }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <img   src="/Oficial/Assets/Images/klipartz.com - 2021-06-24T221843.334.png" width="90" height="90">

    <h1 class="center" style="color: aliceblue; ">BOLETA DE VENTA</h1>
</nav>
<div style="padding-top:100px;" >

</div>

<!-- datos de la empresa -->

<div class="container py-3" >
    <header>
        <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
            <img src="/Oficial/Assets/Images/logo2.png" alt="alt" width="50"/>
            <span class="fs-4">
                        <h3>NOVA X-PRSS</h3>
                    </span>

            <div class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                <div class="row">
                    <div class="col-lg-10">
                        <h5> Boleta de venta Electrónica N°${receipt}</h5>
                        <h6>RUC: 10238238838</h6>
                    </div>
                </div>
            </div>
        </div>
        <!-- datos del cliente -->
        <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
            <form action="">
                <div class="mb-2"  style=" margin-left: 10px;">
                    <label>Fecha de emisión: ${date} </label>
                </div>
                <div class="mb-2" style=" margin-left: 65px;">
                    <label>Cliente: ${names}</label>
                </div>

                <div class="mb-2" style=" margin-left: 103px;">
                    <label>DNI: ${docIdentity}</label>
                </div>
                <div class="mb-2" style=" margin-left: 65px;">
                    <label>Dirección: ${address}</label>
                </div>

                <div class="mb-2" style=" margin-left: 13px;">
                    <label>Tipo de moneda: NUEVOS SOLES</label>
                </div>
                <div class="mb-2" style=" margin-left: 65px;">
                    <label>Repartidor: ${namesEmployee}</label>
                </div>
            </form>
        </div>
    </header>

    <!-- tabla de la compra -->
    <main>
        <div class="pricing-header p-1 pb-md-2 mx-auto text-center">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Unidades</th>
                    <th scope="col">Precio unitario</th>
                    <th scope="col">Importe total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="itemCard" items="${cardInfos}">
                    <tr class="table-primary">
                        <td>${itemCard.getProduct().getIdProduct()}</td>
                        <td>${itemCard.getProduct().getName()}</td>
                        <td>${itemCard.getQuantityz()}</td>
                        <td>S/${itemCard.getProduct().getPrice()}0</td>
                        <td>${itemCard.getSubtotal()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row row-cols-1 row-cols-md-7 mb-3 text-end">
            <form action="">
                <div style="margin-right: 105px">
                    <c:set var="total" value="${cardTotal}"/>
                    <label>Importe total: S/${total}0 </label>
                </div>
            </form>
        </div>

    </main>
</div>

<footer class="pt-4 my-md-5 pt-md-5 border-top text-center">
    <br>
    <img src="/Oficial/Assets/Images/firma.png" alt="" width="150">
    <p><b>Firma</b></p>
    <button class="oculto-impresion btn btn-info" onclick="imprimir()">Imprimir</button>
</footer>


<!-- Button trigger modal -->

<div class="text-al" style="margin-left:95%">
    <button type="button" class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#exampleModal">
        X
    </button>
</div>
Modal
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered text-light">
        <div class="modal-content bg-dark text-light">
            <div class="modal-header bg-dark text-light">
                <h3 class="modal-title" id="exampleModalLabel">¡Muchas gracias por su compra!</h3>
                <button type="button" class="btn-close" style="background-color: #ff0000" data-bs-dismiss="modal" aria-label="Close" onclick="location.href = 'SHome?action=list'"></button>
            </div>
            <div class="modal-body text-center">
                Compra exitosa
            </div>
            <div align = "center" style="margin-bottom: 10px">
                <a href="https://docs.google.com/forms/d/e/1FAIpQLScdZJ83oav2RQO3rzizr8n0NCm13oYFj8p-xjRiQe_ePxiTHw/viewform" target="_blank"
                   class="btn btn-primary">
                    Responder encuesta
                </a>
            </div>
        </div>
    </div>
</div>

<script>function imprimir() {window.print(); } </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
