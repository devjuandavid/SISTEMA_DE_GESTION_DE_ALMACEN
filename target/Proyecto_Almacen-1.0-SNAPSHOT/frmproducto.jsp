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

        <title>TIPOS</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="productos" />
        </jsp:include>
        <div class="container">

            <h1>Formulario de Productos</h1>

            <br>
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="id_producto" value="${producto.id_producto}" >
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${producto.nombre}" placeholder="Escriba su Nombre">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Stock</label>
                    <input type="text" class="form-control" name="stock" value="${producto.stock}" placeholder="Escriba su Stock">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Tipo</label>
                    <select name="id_tipo" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_tipos}">
                            <option value="${item.id_tipo}" 
                                    <c:if test="${producto.id_tipo == item.id_tipo}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Marcas</label>
                    <select name="id_marcas" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_marcas}">
                            <option value="${item.id_marcas}" 
                                    <c:if test="${producto.id_marcas == item.id_marcas}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Caracteristica</label>
                    <select name="id_caracteristica" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_caracteristicas}">
                            <option value="${item.id_caracteristica}" 
                                    <c:if test="${producto.id_caracteristica == item.id_caracteristica}">
                                        selected
                                    </c:if>
                                    >${item.tipo}</option>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>    

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>