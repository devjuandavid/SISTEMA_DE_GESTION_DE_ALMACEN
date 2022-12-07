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
            <jsp:param name="opcion" value="tipos" />
        </jsp:include>
        <div class="container">

            <h1>Formulario de Tipos</h1>

            <br>
            <form action="TipoControlador" method="post">
                <input type="hidden" name="id_tipo" value="${tipo.id_tipo}" >
                <div class="mb-3">
                    <label for="" class="form-label">Proveedor</label>
                    <select name="id_proveedores" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_proveedores}">
                            <option value="${item.id_proveedores}" 
                                    <c:if test="${tipo.id_proveedores == item.id_proveedores}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Compras</label>
                    <select name="id_compras" class="form-control">
                        <option value="">-- Selecione --</option>
                        <c:forEach var="item" items="${lista_compras}">
                            <option value="${item.id_compras}" 
                                    <c:if test="${tipo.id_compras == item.id_compras}">
                                        selected
                                    </c:if>
                                    >${item.descripcion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${tipo.nombre}" placeholder="Escriba su Nombre">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Detalle</label>
                    <input type="text" class="form-control" name="detalle" value="${tipo.detalle}" placeholder="Escriba su Detalle">
                </div>


                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>    

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
