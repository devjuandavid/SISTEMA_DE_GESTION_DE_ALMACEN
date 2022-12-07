<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("login") != "ok") {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>VENTAS_PODUCTOS</title>
    </head>
    <body class="box">
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="venta_productos" />
        </jsp:include>
        <div class="container">
            <br>
            <center>
                <div class="loader">
                    <h1>
                        <span>VENTAS_PODUCTOS</span>
                        <span>VENTAS_PODUCTOS</span>
                    </h1>

                </div>
            </center>

            <br>
            <a  class="btn btn-primary btn-sm" href="Venta_productoControlador?action=add"><i class="fa-solid fa-circle-plus"></i> Nuevo </a>
            <table class="table table-dark table-striped">
                <tr>
                    <th>Id</th>
                    <th>Venta</th>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Descuento</th>
                    <th>Precio</th>
                    <th>Total</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${venta_productos}">
                    <tr>
                        <td>${item.id_venta_producto}</td>
                        <td>${item.ventas}</td>
                        <td>${item.producto}</td>
                        <td>${item.cantidad}</td>
                        <td>${item.descuento}</td>
                        <td>${item.precio}</td>
                        <td>${item.total}</td>
                        <td><a href="Venta_productoControlador?action=edit&id_venta_producto=${item.id_venta_producto}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="Venta_productoControlador?action=delete&id_venta_producto=${item.id_venta_producto}" onclick="return(confirm('Esta Seguro ??'))"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
