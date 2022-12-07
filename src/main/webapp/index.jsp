<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String opc = request.getParameter("opcion");

    if (session.getAttribute("login") != "ok") {
        response.sendRedirect("login.jsp");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMACEN</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body  class="box">

        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="index" />
        </jsp:include>
        <br><br>
    <center>
        <div class="loader">
            <h1>
                <span>ALMACEN</span>
                <span>ALMACEN</span>
            </h1>

        </div>
    </center>
    <br>
    <br>
    <center> 
        <div class="spinner">
            <span>B</span>
            <span>i</span>
            <span>e</span>
            <span>n</span>
            <span>v</span>
            <span>e</span>
            <span>n</span>
            <span>i</span>
            <span>d</span>
            <span>o</span>
            <span>s</span>
        </div>
    </center>
    <section class="cuerpo">
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/almacen.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="ProductoControlador?action=view">Información</a></h2>
                <span class="caption">Productos</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/proveedores.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="ProveedorControlador?action=view">Información</a></h2>
                <span class="caption">Proveedores</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/marcas.jpg">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="MarcaControlador?action=view">Información</a></h2>
                <span class="caption">Marcas</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/tipos.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="TipoControlador?action=view">Información</a></h2>
                <span class="caption">Tipos</span>
            </div>
        </div>
    </section>
    <br>><br>
    <section class="cuerpo">
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/tallas.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="TallaControlador?action=view">Información</a></h2>
                <span class="caption">Tallas</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/compras.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="CompraControlador?action=view">Información</a></h2>
                <span class="caption">Compras</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/caracteristicas.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="CaracteristicaControlador?action=view">Información</a></h2>
                <span class="caption">Caracteristicas</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/producto_tallas.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="Producto_tallaControlador?action=view">Información</a></h2>
                <span class="caption">Producto Tallas</span>
            </div>
        </div>
    </section>
    <br><br>
    <section class="cuerpo">
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/empleados.jpg">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="EmpleadoControlador?action=view">Información</a></h2>
                <span class="caption">Empleados</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/ventas.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="VentaControlador?action=view">Información</a></h2>
                <span class="caption">Ventas</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/venta_productos.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="Venta_productoControlador?action=view">Información</a></h2>
                <span class="caption">Venta Productos</span>
            </div>
        </div>
        <div class="card">
            <div class="imgbox">
                <div class="img">
                    <img src="img/usuario.gif">
                </div>
            </div>
            <div class="details">
                <h2 class="title"><a href="UsuarioControlador?action=view">Información</a></h2>
                <span class="caption">Usuarios</span>
            </div>
        </div>
    </section>
    <br><br>
</body>
</html>
