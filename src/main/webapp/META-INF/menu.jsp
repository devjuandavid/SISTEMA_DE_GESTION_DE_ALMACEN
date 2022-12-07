
<%
    String opcion = request.getParameter("opcion");
%>
<aside class="aside">
    <div class="movie-list">
        <ul>
            <li id="inicio">
                <a href="index.jsp"><span class="icon-list <%= (opcion.equals("index") ? "active" : "")%>"><i></i></span>Inicio</a>
            </li>
            <li id="usuario">
                <a href="UsuarioControlador"><span class="icon-list <%= (opcion.equals("usuarios") ? "active" : "")%>"><i></i></span>Usuarios</a>
            </li>
            <li id="proveedores">
                <a href="ProveedorControlador"><span class="icon-list <%= (opcion.equals("proveedores") ? "active" : "")%>"><i></i></span>Proveedores</a>
            </li>
            <li id="empleados">
                <a href="EmpleadoControlador"><span class="icon-list <%= (opcion.equals("empleados") ? "active" : "")%>"><i></i></span>Empleados</a>
            </li>
            <li id="compras">
                <a href="CompraControlador"><span class="icon-list <%= (opcion.equals("compras") ? "active" : "")%>"><i></i></span>Compras</a>
            </li>
            <li id="ventas">
                <a href="VentaControlador"><span class="icon-list <%= (opcion.equals("ventas") ? "active" : "")%>"><i></i></span>Ventas</a>
            </li>
            <li id="marcas">
                <a href="MarcaControlador"><span class="icon-list <%= (opcion.equals("marcas") ? "active" : "")%>"><i></i></span>Marcas</a>
            </li>
            <li id="caracteristicas">
                <a href="CaracteristicaControlador"><span class="icon-list <%= (opcion.equals("caracteristicas") ? "active" : "")%>"><i></i></span>Caracteristicas</a>
            </li>
            <li id="tipos">
                <a href="TipoControlador"><span class="icon-list <%= (opcion.equals("tipos") ? "active" : "")%>"><i></i></span>Tipos</a>
            </li>
            <li id="tallas">
                <a href="TallaControlador"><span class="icon-list <%= (opcion.equals("tallas") ? "active" : "")%>"><i></i></span>Tallas</a>
            </li>
            <li id="productos">
                <a href="ProductoControlador"><span class="icon-list <%= (opcion.equals("productos") ? "active" : "")%>"><i></i></span>Productos</a>
            </li>
            <li id="venta_productos">
                <a href="Venta_productoControlador"><span class="icon-list <%= (opcion.equals("venta_productos") ? "active" : "")%>"><i></i></span>Venta_productos</a>
            </li>
            <li id="producto_tallas">
                <a href="Producto_tallaControlador"><span class="icon-list <%= (opcion.equals("producto_tallas") ? "active" : "")%>"><i></i></span>Producto_tallas</a>
            </li>
            <li id="logout">
                <a href="Logout"><span class="icon-list <%= (opcion.equals("logout") ? "active" : "")%>"><i></i></span>Cerra sesión</a>
            </li>
        </ul>
    </div>
</aside>
