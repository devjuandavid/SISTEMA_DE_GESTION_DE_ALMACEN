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

        <title>PRODUCTO_TALLAS</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="producto_tallas" />
        </jsp:include>
        <div class="container">

            <h1>Formulario de PRoducto Tallas</h1>

            <br>
            <form action="Producto_tallaControlador" method="post">
                <input type="hidden" name="id_producto_talla" value="${producto_talla.id_producto_talla}" >
                <div class="mb-3">
                    <label for="" class="form-label">Producto</label>
                    <select name="id_producto" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_productos}">
                            <option value="${item.id_producto}" 
                                    <c:if test="${producto_talla.id_producto == item.id_producto}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Tallas</label>
                    <select name="id_talla" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_tallas}">
                            <option value="${item.id_talla}" 
                                    <c:if test="${producto_talla.id_talla == item.id_talla}">
                                        selected
                                    </c:if>
                                    >${item.medida}</option>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>    

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
