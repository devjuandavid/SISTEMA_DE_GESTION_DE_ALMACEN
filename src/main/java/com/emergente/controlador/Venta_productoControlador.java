package com.emergente.controlador;

import com.emergente.dao.ProductoDAO;
import com.emergente.dao.ProductoDAOimpl;
import com.emergente.dao.VentaDAO;
import com.emergente.dao.VentaDAOimpl;
import com.emergente.dao.Venta_productoDAO;
import com.emergente.dao.Venta_productoDAOimpl;
import com.emergente.modelo.Producto;
import com.emergente.modelo.Venta;
import com.emergente.modelo.Venta_producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Venta_productoControlador", urlPatterns = {"/Venta_productoControlador"})
public class Venta_productoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Venta_productoDAO dao = new Venta_productoDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            VentaDAO daoVenta = new VentaDAOimpl();
            int id;
            List<Producto> lista_productos = null;
            List<Venta> lista_ventas = null;

            Venta_producto venpro = new Venta_producto();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_productos = daoProducto.getAll();
                    lista_ventas = daoVenta.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_ventas", lista_ventas);
                    request.setAttribute("venta_producto", venpro);
                    request.getRequestDispatcher("frmventa_producto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_venta_producto"));
                    venpro = dao.getById(id);

                    lista_productos = daoProducto.getAll();
                    lista_ventas = daoVenta.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_ventas", lista_ventas);

                    request.setAttribute("venta_producto", venpro);
                    request.getRequestDispatcher("frmventa_producto.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_venta_producto"));
                    dao.delete(id);
                    response.sendRedirect("Venta_productoControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Venta_producto> lista = dao.getAll();
                    request.setAttribute("venta_productos", lista);
                    request.getRequestDispatcher("venta_productos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_venta_producto"));
        int id_ventas = Integer.parseInt(request.getParameter("id_ventas"));
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Double descuento = Double.parseDouble(request.getParameter("descuento"));
        Double precio = Double.parseDouble(request.getParameter("precio"));
        Double total = Double.parseDouble(request.getParameter("total"));
        
        Venta_producto venpro = new Venta_producto();

        venpro.setId_venta_producto(id);
        venpro.setId_ventas(id_ventas);
        venpro.setId_producto(id_producto);
        venpro.setCantidad(cantidad);
        venpro.setDescuento(descuento);
        venpro.setPrecio(precio);
        venpro.setTotal(total);

        if (id == 0) {
            //Nuevo
            Venta_productoDAO dao = new Venta_productoDAOimpl();
            try {
                // Nuevo registro
                dao.insert(venpro);
                response.sendRedirect("Venta_productoControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            Venta_productoDAO dao = new Venta_productoDAOimpl();
            try {
                dao.update(venpro);
                response.sendRedirect("Venta_productoControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

}
